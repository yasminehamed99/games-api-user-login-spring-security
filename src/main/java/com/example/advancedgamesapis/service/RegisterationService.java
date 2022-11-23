package com.example.advancedgamesapis.service;

import com.example.advancedgamesapis.dto.RegisterationRequest;
import com.example.advancedgamesapis.entity.AppUser;
import com.example.advancedgamesapis.entity.ConfirmationToken;
import com.example.advancedgamesapis.registeration.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class RegisterationService {
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    private final ConfirmationService confirmationService;
@Autowired
    public RegisterationService(AppUserService appUserService, EmailValidator emailValidator, ConfirmationService confirmationService) {
        this.appUserService = appUserService;
        this.emailValidator = emailValidator;
    this.confirmationService = confirmationService;
}

    public String register(RegisterationRequest request) {
       boolean isValidEmail= emailValidator.test(request.getEmail());
       if(!isValidEmail){
           throw new IllegalStateException("email not valid");
       }
        String token= appUserService.signUpUser(
                new AppUser(
                        request.getName(),
                        request.getEmail(),
                        request.getPassword()
                )
        );

       return token;
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken =confirmationService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));



        LocalDateTime expiredAt = confirmationToken.getExpiredAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationService.setConfirmedAt(token);
        appUserService.enableAppUser(
                confirmationToken.getAppUser().getEmail());
        return "confirmed";
    }
}

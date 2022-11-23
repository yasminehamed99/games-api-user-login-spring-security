package com.example.advancedgamesapis.service;

import com.example.advancedgamesapis.entity.ConfirmationToken;
import com.example.advancedgamesapis.repository.ConfirmationRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service

public class ConfirmationService {
private final ConfirmationRepositry confirmationRepositry;
@Autowired
    public ConfirmationService(ConfirmationRepositry confirmationRepositry) {
        this.confirmationRepositry = confirmationRepositry;
    }
    public void saveConfirmationToken(ConfirmationToken confirmationToken){
    confirmationRepositry.save(confirmationToken);

    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationRepositry.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationRepositry.updateConfirmedAt(
                token, LocalDateTime.now());
    }

}

package com.example.advancedgamesapis.service;

import com.example.advancedgamesapis.dto.GetUserInfo;
import com.example.advancedgamesapis.entity.AppUser;
import com.example.advancedgamesapis.entity.ConfirmationToken;
import com.example.advancedgamesapis.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppUserService implements UserDetailsService {
    private final static String user_not_found="user with email %s not found";

private final PlayerRepository playerRepository;
private final BCryptPasswordEncoder bCryptPasswordEncoder;
private final ConfirmationService confirmationService;

@Autowired
    public AppUserService(PlayerRepository playerRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ConfirmationService confirmationService) {
        this.playerRepository = playerRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    this.confirmationService = confirmationService;
}

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return playerRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException(String.format(user_not_found,email)));
    }
    public String signUpUser(AppUser appUser){
   boolean userExists= playerRepository.findByEmail(appUser.getEmail())
           .isPresent();
   if(userExists){
       throw new IllegalStateException("email already taken");
   }
   String encodedPass=bCryptPasswordEncoder
           .encode(appUser.getPassword());
    appUser.setPassword(encodedPass);
    playerRepository.save(appUser);
        String  token =UUID.randomUUID().toString();
        ConfirmationToken confirmationToken=new ConfirmationToken(
                token, LocalDateTime.now(),
                LocalDateTime.now().plusHours(1),appUser);
        confirmationService.saveConfirmationToken(confirmationToken);





    return token;
    }
    public void saveUser(AppUser user){
        playerRepository.save(user);
    }


        public int enableAppUser(String email) {
            return playerRepository.enableAppUser(email);
        }
        public AppUser getAppUser() throws Exception {
            String currentUserName=null;
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (!(authentication instanceof AnonymousAuthenticationToken)) {
                 currentUserName = authentication.getName();

            }
            Optional<AppUser> user=playerRepository.findByEmail(currentUserName);
            if (!user.isPresent()) {
                throw new Exception("user not present");
            }
            return user.get();

        }
        public GetUserInfo getUserInfo() throws Exception {
        AppUser appUser=getAppUser();
        GetUserInfo getUserInfo=new GetUserInfo();
        getUserInfo.setName(appUser.getName());
        getUserInfo.setEmail(appUser.getEmail());
        getUserInfo.setRockPaperSicssors(appUser.getRockPaperSicssors());
        getUserInfo.setTowerHanoiScore(appUser.getTowerHanoiScore());
        getUserInfo.getGreedDiceGameScore(appUser.getGreedDiceGameScore());
        getUserInfo.setCalcDamageGame(appUser.getCalcDamageGame());
        return getUserInfo;



        }


}

package com.example.advancedgamesapis.controller;

import com.example.advancedgamesapis.dto.CalculateDamageGame;
import com.example.advancedgamesapis.dto.PlayGreedDice;
import com.example.advancedgamesapis.dto.PlayTowerHanoi;
import com.example.advancedgamesapis.dto.RockPaperSicssors;
import com.example.advancedgamesapis.entity.AppUser;
import com.example.advancedgamesapis.service.AppUserService;
import com.example.advancedgamesapis.service.PlayGamesService;
import com.example.advancedgamesapis.service.RegisterationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/playgames")
public class GamesController {
    private final RegisterationService registerationService;
    private final PlayGamesService playGamesService;
    private final AppUserService appUserService;

    @Autowired
    public GamesController(RegisterationService registerationService, PlayGamesService playGamesService, AppUserService appUserService) {
        this.registerationService = registerationService;
        this.playGamesService = playGamesService;
        this.appUserService = appUserService;
    }

    @PostMapping(path = "playTowerHanoi")
    public int playTowerHanoiGame(@RequestBody PlayTowerHanoi playTowerHanoi) throws Exception {

        int score= playGamesService.towerHanoi(playTowerHanoi.getDiscs());
        AppUser user=appUserService.getAppUser();
        user.setTowerHanoiScore(score);
        appUserService.saveUser(user);
        return score;


    }
    @PostMapping(path = "playDice")
    public int playGreedDice(@RequestBody PlayGreedDice playGreedDice) throws Exception {

        int score= playGamesService.diceScore(playGreedDice.getThrowss());
        AppUser user=appUserService.getAppUser();
        user.setGreedDiceGameScore(score);
        appUserService.saveUser(user);
        return  score;

    }
    @PostMapping(path = "playCalcDamage")
    public double playCalcDamage(@RequestBody CalculateDamageGame calculateDamageGame) throws Exception {

        double score= playGamesService.calculateDamage(calculateDamageGame.getYourType(),calculateDamageGame.getYourAttack());
        AppUser user=appUserService.getAppUser();
        user.setCalcDamageGame(score);
        appUserService.saveUser(user);
        return score;




    }

    @PostMapping(path = "playRockPaper")
    public int playRockPaper(@RequestBody RockPaperSicssors rockPaperSicssors) throws Exception {
        int score =0;
        String winner=null;

        winner=playGamesService.getWinner(rockPaperSicssors.getYourPlay());
        if(winner=="p1")
            score+=1;
        AppUser user=appUserService.getAppUser();
        user.setRockPaperSicssors(score);
        appUserService.saveUser(user);
        return score;



    }
}


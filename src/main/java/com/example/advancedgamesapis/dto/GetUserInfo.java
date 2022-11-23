package com.example.advancedgamesapis.dto;

public class GetUserInfo {
    private  String name;
    private String email;
    private int greedDiceGameScore;
    private int towerHanoiScore;
    private int rockPaperSicssors;
    private double calcDamageGame;

    public GetUserInfo(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public GetUserInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGreedDiceGameScore(int greedDiceGameScore) {
        return this.greedDiceGameScore;
    }

    public void setGreedDiceGameScore(int greedDiceGameScore) {
        this.greedDiceGameScore = greedDiceGameScore;
    }

    public int getTowerHanoiScore() {
        return towerHanoiScore;
    }

    public void setTowerHanoiScore(int towerHanoiScore) {
        this.towerHanoiScore = towerHanoiScore;
    }

    public int getRockPaperSicssors() {
        return rockPaperSicssors;
    }

    public void setRockPaperSicssors(int rockPaperSicssors) {
        this.rockPaperSicssors = rockPaperSicssors;
    }

    public double getCalcDamageGame() {
        return calcDamageGame;
    }

    public void setCalcDamageGame(double calcDamageGame) {
        this.calcDamageGame = calcDamageGame;
    }
}


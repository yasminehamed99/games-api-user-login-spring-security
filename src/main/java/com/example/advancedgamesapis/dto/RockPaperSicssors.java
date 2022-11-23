package com.example.advancedgamesapis.dto;

public class RockPaperSicssors {
    String[] yourPlay=new String[3];

    public RockPaperSicssors(String[] yourPlay) {
        this.yourPlay = yourPlay;
    }

    public RockPaperSicssors() {
    }

    public String[] getYourPlay() {
        return yourPlay;
    }

    public void setYourPlay(String[] yourPlay) {
        this.yourPlay = yourPlay;
    }
}

package com.example.advancedgamesapis.dto;

public class CalculateDamageGame {
    private String yourType;
    private int yourAttack;

    public CalculateDamageGame() {
    }

    public CalculateDamageGame(String yourType, int yourAttack) {
        this.yourType = yourType;
        this.yourAttack = yourAttack;
    }

    public String getYourType() {
        return yourType;
    }

    public void setYourType(String yourType) {
        this.yourType = yourType;
    }

    public int getYourAttack() {
        return yourAttack;
    }

    public void setYourAttack(int yourAttack) {
        this.yourAttack = yourAttack;
    }
}

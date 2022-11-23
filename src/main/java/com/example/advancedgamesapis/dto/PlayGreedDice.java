package com.example.advancedgamesapis.dto;

public class PlayGreedDice {
    int[]throwss=new int[6];

    public PlayGreedDice() {
    }

    public PlayGreedDice(int[] throwss) {
        this.throwss = throwss;
    }

    public int[] getThrowss() {
        return throwss;
    }

    public void setThrowss(int[] throwss) {
        this.throwss = throwss;
    }

}

package com.example.advancedgamesapis.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PlayGamesService {
    public  int towerHanoi(int discs) {

        if (discs == 0) return 0;

        if (discs < 0) throw new RuntimeException("What? A negative number of rings?");

        // count(n-1) + 1 + count(n-1)... since we aren't actually moving
        // the rings, but merely counting the number of moves, we can do
        // it a little more cheaply by just multiplying by 2 rather than
        // calling the recursive method twice

        return 2 * towerHanoi(discs - 1) + 1;

    }
    public  int diceScore(int[]throwss) {
        int oneCount = 0;
        int twoCount = 0;
        int threeCount = 0;
        int fourCount = 0;
        int fiveCount = 0;
        int sixCount = 0;
        int totalScore = 0;

        // Record number of times each number was rolled
        for (int i = 0; i < throwss.length; i++) {
            if (throwss[i] == 1) {
                oneCount++;
            } else if (throwss[i] == 2) {
                twoCount++;
            } else if (throwss[i] ==3) {
                threeCount++;
            } else if (throwss[i] == 4) {
                fourCount++;
            } else if (throwss[i] == 5) {
                fiveCount++;
            } else if (throwss[i] == 6) {
                sixCount++;
            }
        }

        // Check for amount of times each number was rolled
        if (oneCount == 3) {
            totalScore += 1000;
        } else if (twoCount == 3) {
            totalScore += 200;
        } else if (threeCount == 3) {
            totalScore += 300;
        } else if (fourCount == 3) {
            totalScore += 400;
        } else if (fiveCount == 3) {
            totalScore += 500;
        } else if (sixCount == 3) {
            totalScore += 600;
        }

        // Check for instance of one '1'
        if (oneCount == 1) {
            totalScore += 100;
        }

        // Check for instance of one '5'
        if (fiveCount == 1) {
            totalScore += 50;
        }

        return totalScore;
    }
    public static double calcEffectiveness(String attacker, String opponent){
//        fire > grass
//        fire < water
//                fire = electric
//        water < grass
//        water < electric
//                grass = electric
        if(attacker=="fire")
        {
            if(opponent=="grass")
                return 2;
            else if (opponent=="water")
                return 0.5;
            else if (opponent=="electric")
                return 1;
            else if(opponent=="fire")
                return 1;

        }
        if(attacker=="water"){
            if(opponent=="grass")
                return 0.5;
            else if (opponent=="electric")
                return 0.5;
            else if (opponent=="fire")
                return 2;
            else if (opponent=="water")
                return 1;
        }
        //        fire > grass
//        fire < water
//                fire = electric
//        water < grass
//        water < electric
//                grass = electric
        if(attacker=="grass"){
            if(opponent=="water")
                return 2 ;
            else if (opponent=="fire")
                return 0.5;
            else if(opponent=="electric")
                return 1;
            else if(opponent=="grace")
                return 1;
        }
        //        fire > grass
//        fire < water
//                fire = electric
//        water < grass
//        water < electric
//                grass = electric
        if(attacker=="electric"){
            if(opponent=="water")
                return 2 ;
            else if (opponent=="fire")
                return 1;
            else if(opponent=="electric")
                return 1;
            else if(opponent=="grace")
                return 1;
        }

        return 0;


    }
    public  double calculateDamage(String yourType,int attack){
        final String[] proper_noun = {"fire", "grass", "water", "electric America"};
        Random random = new Random();
        int index = random.nextInt(proper_noun.length);
        int min = 1;
        int max = 100;

        //Generate random int value from 50 to 100

        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        System.out.println(random_int);

        double damage=50 * (attack / random_int) * calcEffectiveness(yourType,proper_noun[index]);
        return  damage;

    }
    public  String rps(String p1,String p2) {
        switch (p1) {
            case "Rock": {
                if (p2 == "Scissors")
                    return "The winner is  p1" ;
                else if (p2 == "Paper")
                    return "The winner is p2" ;
                else if (p2 == "Rock")
                    return "It's a draw";
            }
            case "Scissors": {
                if (p2 == "Scissors")
                    return "It's a draw";
                else if (p2 == "Paper")
                    return "The winner is p1";
                else if (p2 == "Rock")
                    return "The winner is p2";
            }
            case "Paper": {
                if (p2 == "Scissors")
                    return "The winner is p2" ;
                else if (p2 == "Paper")
                    return "It's a draw";
                else if (p2 == "Rock")
                    return "The winner is p1" ;
            }
            default:
                return "invalid input";

        }
    }
    public  String getWinner(String[]yourTypes){
        final String[] proper_noun = {"Paper", "Rock", "Scissors"};

        int c1=0;
        int c2=0;
        String winner=null;
        for (int i=0;i<3;i++)
        {Random random = new Random();
            int index = random.nextInt(proper_noun.length);
            winner=rps(yourTypes[i],proper_noun[index]);
            if (winner=="The winner is p1")
                c1++;
            else if(winner== "The winner is p2")
                c2++;

        }
        if(c1>c2)
            return "p1";
        else if(c2>c1)
            return "p2";
        if(c2==c1)
            return "equaled";
        return "";
    }
}

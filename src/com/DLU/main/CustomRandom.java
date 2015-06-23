package com.DLU.main;

public class CustomRandom {

    public long getRandomValue(){
        long randomValue = System.nanoTime();
        randomValue = randomValue/1000;
        randomValue = randomValue%1000000000;

        return randomValue;
    }
}

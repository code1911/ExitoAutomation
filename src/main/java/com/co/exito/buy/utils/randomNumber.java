package com.co.exito.buy.utils;


public class randomNumber {

    public randomNumber() {
    }

    public int randomNumberInt(int min, int max){ return (int)(Math.random()*(max-min+1)+min); }

}

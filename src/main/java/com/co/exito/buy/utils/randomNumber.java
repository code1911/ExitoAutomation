package com.co.exito.buy.utils;


import java.util.HashSet;
import java.util.Set;

public class randomNumber {

    public randomNumber() {
    }

    public int randomNumberInt(int min, int max){ return (int)(Math.random()*(max-min+1)+min); }

    public Set<Integer> randomNumberIntSet(int min, int max){
        Set<Integer> numbers = new HashSet<>();
        for (int i = 1; i <= 5; i++) {
            int aleatorio = -1;
            boolean generado = false;
            while (!generado) {
                int possible =(int)(Math.random()*(max-min+1)+min);
                if (!numbers.contains(possible)) {
                    numbers.add(possible);
                    aleatorio = possible;
                    generado = true;
                }
            }
        }
        return  numbers;
    }

}

package com.aybaroud.examples;

public class Random {

    public int square(int x){
        return x * x;
    }

    public int countA(String word){
        int aNumber = 0;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == 'a' || word.charAt(i) == 'A'){
                aNumber++;
            }
        }
        return aNumber;
    }

}

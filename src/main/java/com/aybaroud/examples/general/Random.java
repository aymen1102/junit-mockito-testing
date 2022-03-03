package com.aybaroud.examples.general;

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

    //AACD=>CD
    //ACD=>CD
    //CDEF=>CDEF
    //CDAA=>CDAA
    public String truncateAInTheTwoFirstPosition(String str){
        if(str.length() <= 2)
            return str.replaceAll("A","");
        String first2Chars = str.substring(0,2);
        String without2Chars = str.substring(2);
        return  first2Chars.replaceAll("A","") +
                without2Chars;
    }

    //ABCD => false
    //ABAB => true
    //AB => true
    //A => false
    public boolean areFirstAndLastTwoCharactersTheSame(String str){
        if(str.length() <= 1 )
            return false;
        if(str.length() == 2)
            return true;

        String first2Chars = str.substring(0,2);
        String last2Chars = str.substring(str.length() - 2);

        return first2Chars.equals(last2Chars);
    }


}

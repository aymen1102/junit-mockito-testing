package com.aybaroud.junitExamples;

public class JunitExamples {

    /////////////////////////////////////////////////////////////////////////////////////
    ///                          determineLetterGrade                                 ///
    /////////////////////////////////////////////////////////////////////////////////////
    public char determineLetterGrade(int numberGrade){
        if(numberGrade < 0)
            throw new IllegalArgumentException("Number grade cannot be determined");

        else if(numberGrade < 60)
            return 'F';
        else if(numberGrade < 70)
            return 'D';
        else if(numberGrade < 80)
            return  'C';
        else if(numberGrade < 90)
            return 'B';
        else
            return 'A';
    }

    /////////////////////////////////////////////////////////////////////////////////////
    ///                          add                                                  ///
    /////////////////////////////////////////////////////////////////////////////////////
    public int add(int a, int b) {
        return a + b;
    }

    /////////////////////////////////////////////////////////////////////////////////////
    ///                          square                                               ///
    /////////////////////////////////////////////////////////////////////////////////////
    public int square(int x){
        return x * x;
    }

    /////////////////////////////////////////////////////////////////////////////////////
    ///                          countA                                               ///
    /////////////////////////////////////////////////////////////////////////////////////
    public int countA(String word){
        int aNumber = 0;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == 'a' || word.charAt(i) == 'A'){
                aNumber++;
            }
        }
        return aNumber;
    }

    /////////////////////////////////////////////////////////////////////////////////////
    ///                          truncateAInTheTwoFirstPosition                       ///
    /////////////////////////////////////////////////////////////////////////////////////
    /* AACD=>CD     ACD=>CD        CDEF=>CDEF       CDAA=>CDAA */
    public String truncateAInTheTwoFirstPosition(String str){
        if(str.length() <= 2)
            return str.replaceAll("A","");
        String first2Chars = str.substring(0,2);
        String without2Chars = str.substring(2);
        return  first2Chars.replaceAll("A","") +
                without2Chars;
    }

    /////////////////////////////////////////////////////////////////////////////////////
    ///                          areFirstAndLastTwoCharactersTheSame                  ///
    /////////////////////////////////////////////////////////////////////////////////////
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

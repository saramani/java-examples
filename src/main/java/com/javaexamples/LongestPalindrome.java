package com.javaexamples;

/**
 * Created by Sivaram on 8/10/16.
 */
public class LongestPalindrome {


    public static void main(String args[]) {
        //System.out.println(isPalindrome("madam"));
        System.out.println(longestPalindrome1("dabcba"));
    }

    //First cut Not efficient Naive approach
    public static String longestPalindrome1(String s) {
        //int maxPalinLength = 0;
        String longestPalindrome = null;
        int length = s.length();
        //Check all possible substrings
        for(int i=0 ; i < length; i ++){
            for(int j = i +1 ; j< length ; j++){
                //int len = j - i;
                String currSubStr = s.substring(i, j + 1);
                System.out.println(String.format("Current SubString %s between pos %d and pos %d", currSubStr, i , j+1));
                if(isPalindrome(currSubStr)){
                    longestPalindrome = currSubStr;
                    //maxPalinLength = len;
                }
            }

        }

        return longestPalindrome;

    }

    public static boolean isPalindrome(String s) {

        //System.out.println(String.format("isPalindrome ? Input String %s length %d",s,s.length()));
        for (int i = 0 ; i < s.length() - 1; i++){
           // System.out.println(String.format("comparing %s at position %d and %s at position %d",s.charAt(i) , i, s.charAt(s.length() - 1 -i), s.length() - 1 -i) );
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }


}

package io.algoexpert.www.java.string;

public class PalindromCheck {

    public static void main(String[] args) {
     isPalindrome("abcba");
    }

    public static boolean isPalindrome(String str) {
        for(int i = 0; i < str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - i - 1))
                return false;
        }
        return true;
    }
}

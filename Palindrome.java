package com.company;

public class Palindrome {
    public boolean isPalindrome(String str){
        Stack<Character> st = new Stack();
        boolean pal = true;
        int length = str.length();
        int half = (length%2==1) ? length/2+1 : length/2;
        for(int i = 0; i< length/2; i++){
            st.push(str.charAt(i));
        }
        for (int i = half; i < length;i++){
            if(str.charAt(i)!=st.pop()) pal = false;
        }
        return pal;
    }
}

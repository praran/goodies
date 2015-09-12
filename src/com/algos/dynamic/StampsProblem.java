package com.algos.dynamic;

import java.util.Arrays;

/**
 * Created by pradeep on 11/09/2015.
 */
public class StampsProblem {


    public static void main(String... args){

        System.out.println(stamps(140,100,70,34,21,10));
    }

    // dynamic programming for large denominations
    public static int stamps(int amount, int... denom){
        int[] stamps = new int[amount + 1];
        stamps[0] = 0;

        for(int i =1; i <= amount ; i++){
            int j = 0;
            while(denom[j] > i) j++;
            stamps[i] = stamps[i - denom[j]] + 1;
            for(j++ ; j < denom.length; j++){
                stamps[i] = Math.min(stamps[i], stamps[i - denom[j]] + 1);
            }
        }

        return stamps[amount];
    }


    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }



    public String reverseSentence(String s) {
        String r = this.reverseString(s);
        int start = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= r.length(); i++) {
            if (r.length() == i || r.charAt(i) == ' ') {
                String word = r.substring(start, i);
                String reversed = reverseString(word);
                result.append(reversed);
                if (r.length() != i) {
                    result.append(' ');
                }
                start = i + 1;
            }
        }
        return result.toString();
    }

    // iterative approach dynamic programming !!!!!!
    public static int getStampsCount(int amount){
        int a = 1, b=2, c=1, d=1;
        for(int i =1; i < amount; i++){
            int e = Math.min(a+1, Math.min(b+1,  Math.min(c + 1,d+1)));
            a = b; b=c; c=d; d=e;
        }
        return a;
    }

    // Naive Recursion takes Exponential time !!!!!
    public static int getPostageCount(int n){
        if(n ==1){
            return 1;
        }else if (n == 2) {
            return 2;
        }else if(n == 3){
            return 1;
        } else if(n == 4){
            return 1;
        }else{
            return minimum(new int[]{1 + getPostageCount(n-4) , 1 + getPostageCount(n-3), 1 + getPostageCount(n-1)});
        }
    }

    public static int minimum(int... arr){
        Arrays.sort(arr);
        return arr[0];
    }
}

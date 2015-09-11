package com.algos.dynamic;

import java.math.BigInteger;
import java.util.Arrays;

/**
 */
public class PostageProblem {

    /**
     * Postage problem
     * Stamps of  1 , 2, 3, 4
     * case 1 = 1
     * case 2 = 2 => 1 + 1
     * case 3 = 1
     * case 4 = 1
     *
     */


    public static void main(String... args){
       // System.out.println(getPostageCount(10));

      //  System.out.println(getStampsCount(2));

     //   int[] coins = {8 ,47 ,13,24,25,31,32,35,3,19,40,48,1,4,17,38,22,30,33,15,44,46,36,9,20,49};

       int [] coins = {48 ,6 ,34 ,50 ,49 ,36 ,30 ,35 ,40 ,41 ,17 ,43 ,39 ,13 ,4 ,20 ,19 ,2 ,46 ,7 ,38 ,33 ,28 ,18 ,21 };
        System.out.println(getChangeCount(1, coins).toString());
    }


    public static BigInteger getChangeCount(int amount, int[] coins){
        if(amount <= 0) return BigInteger.ZERO;
        if(coins == null || coins.length ==0) return BigInteger.ZERO;
        BigInteger[] dp = new BigInteger[amount + 1];

        dp[0] =BigInteger.ONE ;
        for(int i =0; i < coins.length; ++i){
            for(int j = coins[i]; j <= amount ; ++j){
                if(dp[j] == null) dp[j] = BigInteger.ZERO;
                if(dp[j - coins[i]] == null) dp[j - coins[i]] = BigInteger.ZERO;
                dp[j] = dp[j].add(dp[j - coins[i]]);
            }
        }
        if(dp[amount] != null) {return dp[amount];}
        else{return BigInteger.ZERO;}
    }

    // iterative approach dynamic programming !!!!!!
    public static int getStampsCount(int amount){
        int a = 1, b=2, c=1, d=1;
        for(int i =0; i < amount; i++){
            int e = Math.min(a+1, Math.min(b+1, d+1));
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

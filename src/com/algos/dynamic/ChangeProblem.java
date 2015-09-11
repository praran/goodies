package com.algos.dynamic;

import java.math.BigInteger;

/**
 */
public class ChangeProblem {


    public static void main(String... args){
        // System.out.println(getPostageCount(10));

        //  System.out.println(getStampsCount(2));

        //   int[] coins = {8 ,47 ,13,24,25,31,32,35,3,19,40,48,1,4,17,38,22,30,33,15,44,46,36,9,20,49};

      //  int [] coins = {48 ,6 ,34 ,50 ,49 ,36 ,30 ,35 ,40 ,41 ,17 ,43 ,39 ,13 ,4 ,20 ,19 ,2 ,46 ,7 ,38 ,33 ,28 ,18 ,21 };

         int[] coins = {1,2,3};


        System.out.println(getChange(coins, coins.length, 4));
    }

    // http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/

    // http://www.algorithmist.com/index.php/Coin_Change

    // using dp
    public static int getChange(int[] coins, int nofCoins, int amount){
   //  int i,j,x,y;

        int table[][] = new int[amount+1][nofCoins];
        for(int i=0 ; i < nofCoins; i++){
            table[0][i] =1;
        }

        for(int i =1; i< amount+1; i++){
            for(int j=0; j< nofCoins; j++){
                // Count of solutions including S[j]
                int x = (i - coins[j] >0) ? table[i - coins[j]][j] : 0;
                // Count of solutions excluding S[j]
                int y = (j >=1) ? table[i][j-1] : 0;
                // total count
                table[i][j]= x + y;
            }

        }

        return table[amount][nofCoins -1];
    }


    // Naive recursion
    public static int getChangeCount(int[] coins, int nofCoins, int amount){
        if(amount == 0) return 1;
        if(amount < 0) return 0;
        if(nofCoins <= 0 && amount >= 1) return 0;
        return getChangeCount(coins, nofCoins - 1, amount) + getChangeCount(coins, nofCoins, amount - coins[nofCoins-1]);
    }

    // Simple dp
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
}



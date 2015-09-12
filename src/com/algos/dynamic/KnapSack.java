package com.algos.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pradeep on 12/09/2015.
 */
public class KnapSack {


    public static void main(String... args){
        int[] weights = new int[]{1,3,4,5};
        int[] vals = new int[]{1,4,5,7};

        knapsac(7, weights,vals);
    }


    public static void knapsac(int sum, int[] weights, int[]vals){
        if(sum ==0 || weights.length==0 || vals.length ==0)
            System.out.println("invalid input");

        int[][] dp = new int[weights.length][sum + 1];

        // populate the first row with first val

        for(int col =1; col <= sum; col ++){
            dp[0][1] = vals[0];
        }

        for(int col = 1 ; col < sum+1 ; col++){
            for(int row = 1 ; row < weights.length; row ++){
                if(weights[row] > col){
                    dp[row][col] = dp[row-1][col];
                }else{
                    if((col - weights[row]) >= 0)
                    dp[row][col] = Math.max(vals[row] + dp[row -1][col - weights[row]] , dp[row -1][col]);
                    else
                        dp[row][col] = Math.max(vals[row] , dp[row -1][col]);
                }
            }

        }

        int row = dp.length-1, col = sum;
        List<Integer> res = new ArrayList();

        while(row >0 && col >0){
            if(dp[row][col] == dp[row-1][col]){
                row -= 1;
            }else{
                res.add(vals[row]);
                row -=1;
                col -= weights[row];
            }
        }

        for(int i =0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }


         System.out.println(res);
    }


    public static void knapsack(int weight, int[] weights, int[] vals){
        if(weight ==0 || weights.length ==0 || vals.length == 0) return ;

        int[][] table = new int[weights.length][weight +1];

        for(int i =1; i< table[0].length; i++){
            table[0][i] = vals[0];
        }

        for(int i =1; i < weight +1 ; i ++){
            for(int j = 1; j< table.length; j++){
                if(weights[j] > i){
                    table[j][i]= table[j-1][i];
                }else{
                    if(i - weights[j] >= 0)
                    table[j][i] = Math.max(vals[j]+table[j-1][i - weights[j]], table[j-1][i]);
                    else
                    table[j][i] = Math.max(weights[j], table[j-1][i]);
                }
            }
        }

        for(int i =0; i < table.length; i++){
            for(int j = 0; j < table[0].length; j++){
                System.out.print(table[i][j]);
            }
            System.out.println();
        }

        int row = weights.length-1, col = weight;
        List<Integer> res = new ArrayList();
        while(row >0 && col >0){
            if(table[row][col] == table[row-1][col]){
                row = row - 1;
            }else{
                res.add(weights[row]);
                row-=1;
                col-=weights[row];
            }
        }


    System.out.println(res);

    }

}

package com.algos.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pradeep on 11/09/2015.
 */
public class Actual {
    static int sum =0;

    public static void main(String... args){

        int[] arr = new int[]{0,2,2,4,0,1,3,0};
       // zeroSort(arr);
//        for(int i =0; i < arr.length; i++){
//            System.out.println(arr[i] + ",");
//        }
       // printSumPairs(arr, 4);
       // maxSubArray(4, arr);
        int[][] matrix = new int[3][3];
        matrix[0][0] =1;
        matrix[0][1] =3;
        matrix[0][2] =9;
        matrix[1][0] =2;
        matrix[1][1] =4;
        matrix[1][2] =10;
        matrix[2][0] =15;
        matrix[2][1] =11;
        matrix[2][2] = 17;



        System.out.println(maxField(matrix, 2, 2));
        System.out.println(maxValue(matrix));

        Actual a = new Actual();
        maxField1(matrix, 2, 2);
        System.out.println(sum);
        System.out.println(maxValue2(matrix));

    }
// http://techieme.in/find-pair-of-numbers-in-array-with-a-given-sum/
// http://www.geeksforgeeks.org/find-subarray-with-given-sum/#disqus_thread

    /**
     * Max sub array summing to the number
     * @param sum
     * @param arr
     */
    public static void maxSubArray(int sum, int[] arr){
        if(sum ==0 || arr.length ==0)
            System.out.println("invalid input");
        int curSum = arr[0];
        int start = 0;

        for(int i =1; i< arr.length; i++){
            while(curSum > sum && start < i-1){
                curSum -=arr[start];
                ++start;
            }
            if(curSum == sum){
                System.out.println("fount betweeen  "+ start+ " and " +(i-1));
                System.out.println(arr[start] +"  "+ arr[i-1]);
            }

            curSum += arr[i];


        }

    }

    /**
     * Zeros to one side
     * @param arr
     */
    public static void zeroSort(int[] arr) {
        int zeroCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroCounter++;
            } else  if (zeroCounter > 0) {
                arr[i - zeroCounter] = arr[i];
                arr[i] = 0;
            }
        }
    }

    /**
     * Sum of pairs
     * @param input
     * @param k
     */
    public static void printSumPairs(int []input, int k){
        Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();

        for(int i=0;i<input.length;i++){

            if(pairs.containsKey(input[i]))
                System.out.println(input[i] +", "+ pairs.get(input[i]));
            else
                pairs.put(k-input[i], input[i]);
        }

    }

    /**
     * Given a 2d array what path should i take to maximize
     *
     * Simple recursion
     */

    public static int maxField(int[][] matrix, int row, int col){

        if(row ==0 && col == 0){
            return matrix[0][0];
        }
        int maxtop = -1;
        int maxside = -1;

        if(row == 0 && col>0){
            maxside = matrix[row][col-1];
        }else if(row > 0 && col ==0){
            maxtop = matrix[row-1][col];
        }else if(row > 0 && col >0){
             maxtop = matrix[row-1][col];
             maxside = matrix[row][col-1];
        }

        if(maxtop > maxside){
            return matrix[row][col]+ maxField(matrix, row - 1, col);
        }else{
            return matrix[row][col]+ maxField(matrix, row, col-1);
        }

    }

    public  static void maxField1(int[][] matrix, int row, int col){

        if(row ==0 && col == 0){
           sum += matrix[0][0];
           return;
        }
        int maxtop = -1;
        int maxside = -1;

        if(row == 0 && col>0){
            maxside = matrix[row][col-1];
        }else if(row > 0 && col ==0){
            maxtop = matrix[row-1][col];
        }else if(row > 0 && col >0){
            maxtop = matrix[row-1][col];
            maxside = matrix[row][col-1];
        }

        if(maxtop > maxside){
            sum+=matrix[row][col];
            maxField1(matrix, row - 1, col);
        }else{
            sum+=matrix[row][col];
            maxField1(matrix, row, col - 1);
        }

    }

   public static int maxValue(int[][] field) {
       assert(field != null);
        int r = field.length;
        int c = field[0].length;
        int[][] maxValues = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 && j == 0) {
                    maxValues[i][j] = field[i][j];
                } else if (i == 0 && j >0) {
                    maxValues[i][j] = maxValues[i][j-1] + field[i][j];
                } else if (j == 0 && i >0) {
                    maxValues[i][j] = maxValues[i-1][j] + field[i][j];
                } else {
                    maxValues[i][j] = Math.max(maxValues[i][j-1], maxValues[i-1][j]) + field[i][j];
                }
            }
        }
        return maxValues[r-1][c-1];
    }

    public static int maxValue2(int[][] field) {
        int r = field.length;
        int c = field[0].length;
        int[][] maxValues = new int[r][c];
        int maxValue =0;
        int preValue=0;
        int sideValue=0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 && j == 0) {
                    maxValue += field[i][j];
                } else if (i == 0 && j >0) {
                    maxValue += sideValue + field[i][j];
                } else if (j == 0 && i >0) {
                    maxValue = preValue + field[i][j];
                } else {
                    maxValue += Math.max(sideValue, preValue) + field[i][j];
                }
            }
        }
        return maxValue;
    }

}

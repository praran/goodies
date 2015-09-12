package com.algos.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pradeep on 11/09/2015.
 */
public class Actual {

    public static void main(String... args){

        int[] arr = new int[]{0,2,2,4,0,1,3,0};
       // zeroSort(arr);
//        for(int i =0; i < arr.length; i++){
//            System.out.println(arr[i] + ",");
//        }
       // printSumPairs(arr, 4);
        maxSubArray(4, arr);

    }

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
                System.out.println("fount betweeen  "+ start+ " and " +i);
                System.out.println(arr[start] +"  "+ arr[i]);
            }
            if(i < arr.length){
                curSum += arr[i];
            }

        }

    }


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

//    int add(int x, int y) {
//        while (x ^= y,y = ((x ^ y) & y) << 1){
//        }
//        return x;
//    }
    public static void printSumPairs(int []input, int k){
        Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();

        for(int i=0;i<input.length;i++){

            if(pairs.containsKey(input[i]))
                System.out.println(input[i] +", "+ pairs.get(input[i]));
            else
                pairs.put(k-input[i], input[i]);
        }

    }


}

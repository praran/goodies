package com.algos.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.*;

/**
 * Created by pradeep on 12/09/2015.
 */
public class QuickSort {

    public static void main(String... args){
        int[] arr = {1,2,3,4,5};

        quickSort(arr, 0, arr.length-1);

 for(int i =0; i < arr.length; i++){
     System.out.println(arr[i]);
 }

    }


    public static void quickSort(int[] arr, int low, int high){
         if(low >= high) return;

          int j = partiton(arr, low, high);
          quickSort(arr, low, j);
          quickSort(arr, j+1, high);

    }

    public static void merge(int[] arr , int[] temp, int low, int middle, int high){

        for(int i =0; i <= high; i++){
            temp[i] = arr[i];
        }

        int i = low, j = middle + 1;

        for(int k =0; k< high ; k++){
            if(i > middle) arr[k] = temp[j++];
            if(j > high)   arr[k] = temp[i++];
            if(temp[j] < temp[i]) arr[k] = temp[j++];
            else              arr[k] = temp[i++];
        }

    }


    public static int partition(int[] arr, int low, int high){

        int i = low;
        int j = high +1;
        int elem = arr[low];

        while(true){
            while(arr[++i] < elem) {
                if(i == high) break;
            }

            while(elem < arr[--j]){
                if(j == low) break;
            }

            if(i >= j) break;

            //swap i and j

        }

        //swap low and j

        return j;
    }





    public static int partiton(int[] arr, int low , int high){

        int i = low;
        int elem  = arr[low];
        int j     = high +1;



        while(true){
            // move to right
            while(arr[++i] < elem){
                if(i == high) break;
            }

            while(elem < arr[--j]){
                if(j == low) break;
            }

            if(i >= j) break;

            // swap a i j
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j]  = temp;
        }

        // swap low and j
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j]  = temp;



        return j;
    }
}

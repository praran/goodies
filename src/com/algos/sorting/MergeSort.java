package com.algos.sorting;

/**
 * Created by pradeep on 12/09/2015.
 */
public class MergeSort {




public static void main(String[] args){

    int[] arr = new int[]{1,2,3,4};
    int[] temp = new int[arr.length];
    sort(arr, temp, 0, arr.length - 1);
    for(int i=0; i < arr.length; i++)
    System.out.println(arr[i]);

   }


public  static void sort(int[] arr, int[] temp, int low, int high){

    if(arr == null || arr.length ==0 || high<= low)return;

    int middle = (low + high)/2;
    sort(arr, temp, low, middle);
    sort(arr, temp, middle+1, high);
    merge(arr, temp, low, middle, high);
}

/*
public static void merge(int[] arr, int[] temp, int low, int middle, int high){
    if(arr == null || arr.length ==0 || high<= low)return;

    for(int i =0; i < arr.length; i++){
        temp[i] = arr[i];
    }

    int i = low , j = middle +1;

    for(int k=low; k <= high ; k++){
        if(i > middle)             arr[k] = temp[j++];
        else if(j > high)          arr[k] = temp[i++];
        else if(temp[j] < temp[i]) arr[k] = temp[j++];
        else                       arr[k] = temp[i++];
    }
}
*/

    public static void merge(int[] arr , int[] temp, int low, int middle, int high){

        for(int i =0; i <= high; i++){
            temp[i] = arr[i];
        }

        int i = low, j = middle + 1;

        for(int k =low; k< high ; k++){
            if(i > middle) arr[k] = temp[j++];
            else if(j > high)   arr[k] = temp[i++];
            else if(temp[j] < temp[i]) arr[k] = temp[j++];
            else              arr[k] = temp[i++];
        }

    }



}


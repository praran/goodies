package com.algos.sorting;

/**
 * Created by pradeep on 12/09/2015.
 */
public class MergeSort {


public static void main(String[] args){



}

    public static void mergesort(int[] a, int low, int high){

        int N = high - low;
        if(N <= 1) return;
        int mid = (low + high)/2;
        mergesort(a, low, mid);
        mergesort(a, mid + 1, low);

        int[] temp = new int[N];
        int i = low, j=high;

        for (int k = 0; k < N; k++)
        {
            if (i == mid)
                temp[k] = a[j++];
            else if (j == high)
                temp[k] = a[i++];
            else if (a[j]<a[i])
                temp[k] = a[j++];
            else
                temp[k] = a[i++];
        }
        for (int k = 0; k < N; k++)
            a[low + k] = temp[k];

    }


}

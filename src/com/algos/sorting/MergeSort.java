package com.algos.sorting;

/**
 * Created by pradeep on 12/09/2015.
 */
public class MergeSort {


    private int[] array;
    private int[] aux;
    private int length;

public static void main(String[] args){
   }


public  void sort(int[] inArray){
    this.array = inArray;
    this.length = inArray.length;
    this.aux = new int[length];
}

    private void doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            aux[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (aux[i] <= aux[j]) {
                array[k] = aux[i];
                i++;
            } else {
                array[k] = aux[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = aux[i];
            k++;
            i++;
        }

    }

    //See more at: http://java2novice.com/java-sorting-algorithms/merge-sort/#sthash.uQGL5wNe.dpuf



}


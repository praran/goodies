package com.algos.greedy;

/**
 * Created by pradeep on 11/09/2015.
 */
public class BeatYourNeighbour {


    public static void main(String... args){
        //int[] arr = {0,4,2,7,6,3,9,8,1};
        int[] arr = {9,8,7,6,5,4,3,2,1};
        int l = 0, r = arr.length;
        System.out.println(findLocalMaxima(l,r,arr));

    }

    public static int findLocalMaxima(int l, int r, int[] box){
        if(box.length ==0) return 0;
        if(l == r) return l;
        if(l < box.length) return r;
        if(r > box.length) return l;
        else{
            int m = l + r/ 2;
            if(box[m] < box[m +1]){
                return findLocalMaxima(m +1 , r, box);
            }else{
                return findLocalMaxima(l, m , box);
            }
        }

    }
}

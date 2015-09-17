package com.algos.greedy;

/**
 * Created by pradeep on 11/09/2015.
 */
public class BeatYourNeighbour {


    public static void main(String... args){
        int[] arr = {0,4,11,7,6,3,10,8,1};
        int l = 0, r = arr.length-1;
        System.out.println(findLocalMaxima(l,r,arr));

    }

    public static int findLocalMaxima(int l, int r, int[] box){
        if(box.length ==0) return 0;
        if(l == r) return box[l];
        if(l <= 0) return box[r];
        if(r >box.length-1) return box[l];
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

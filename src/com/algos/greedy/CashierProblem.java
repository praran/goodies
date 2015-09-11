package com.algos.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class CashierProblem {


    public static void main(String... args){
        System.out.println(count(33, new ArrayList<Integer>()));
        System.out.println(change(33));
    }



    // Recursive:
   public static List<Integer> change(int n){
       List<Integer> c = new ArrayList<Integer>();
       if(5 <= n){
           c.add(5);
           c.addAll(change(n-5));
       }else if (3 <= n) {
           c.add(3);
           c.addAll(change(n-3));
       } else if (2 <= n) {
           c.add(2);
           c.addAll(change(n-2));
       } else if (1 <= n) {
           c.add(1);
           c.addAll(change(n-1));
       }
      return c;

   }

    // Iterative:
    public static List<Integer> count(int n , List<Integer> change){
        while(n > 0) {
            if (5 <= n) {
                change.add(5);
                n = n - 5;
            } else if (3 <= n) {
                change.add(3);
                n = n -3;
            } else if (2 <= n) {
                change.add(2);
                n = n-2;
            } else if (1 <= n) {
                change.add(1);
                n = n-1;
            } else {
                return change;
            }
        }

        return change;
    }
}

package com.algos.strings;

/**
 * Created by pradeep on 14/09/2015.
 */
public class Anagram {


    public static void main(String... args){
      //  System.out.println(areAnagrams("aabb","aabb"));

        System.out.println(hasDuplicates("abcdefgha".toCharArray()));

        System.out.println(hasDupsinArray("abcdefgha".toCharArray()));
    }


    public static boolean hasDupsinArray(char[] arr){
        if(arr.length <=1) return false;
        boolean[] table = new boolean[256];
        for(int i=0 ; i< arr.length; i++){
            int val = arr[i];
            if(table[val]){
                return true;
            }else{
                table[val] = true;
            }
        }
         return false;
    }

    /**
     * Array has duplicates
     */

    public static boolean hasDuplicates(char[] arr){

        if(arr.length ==0 || arr.length ==1) return false;

        int checker = 0;

        for(int i =0; i < arr.length ; i++){
            int val = arr[i] - 'a';
            if((checker & (1 << val)) >0){
                return true;
            }else{
                checker |= 1<<val;
            }
        }
        return false;

    }

    /**
     * Anagrams
     * @param s1
     * @param s2
     * @return
     */
    public static boolean areAnagrams(String s1, String s2){
     if(s1.length() != s2.length())return false;

      int[] letters = new int[256];
      int no_of_unique =0, no_of_completed =0;

      char[] s = s1.toCharArray();

       for(char c : s){
           if(letters[c] == 0) ++no_of_unique;
           ++letters[c];
       }

       for(int i =0 ; i < s2.length(); i ++){
           int n = s2.charAt(i);
           if(letters[n] == 0) return false;
           else{
               --letters[n];
               if(letters[n] == 0){
                   // how many letters are completed
                   ++no_of_completed;
                   // if completed == number of chars
                   if(no_of_completed == no_of_unique){
                       return i == s2.length()-1;
                   }
               }
           }

       }

     return false;
    }
}


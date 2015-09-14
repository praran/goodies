package com.algos.linkedlists;

import java.util.LinkedList;


/**
 * Created by pradeep on 14/09/2015.
 */
public class DecimalAddition {

    public static void main(String[] args){
       String l = "111";
        String r = "1";
        System.out.println(binaryAddition(l,r));
        System.out.println(binaryAddition2(l, r));
        binaryAddition3(new int[]{1,1,1}, new int[]{1});

    }

    public static void binaryAddition3(int[] s1, int[] s2) {
        if(s1 == null && s2 == null) return ;
        int first = s1.length-1;
        int second = s2.length-1;
        int res = Math.max(s1.length,s2.length)+1;
        int[] result = new int[res];
        StringBuffer sb = new StringBuffer();
        int carry = 0;

        for(int i = (res-1); i>=0 ; --i){
            int sum = carry;
            if( first < 0 && second <0){
                result[i] = carry;
                break;
            }
            if(first >=0){
                sum += s1[first];
                --first;
            }

            if(second >= 0){
                sum += s2[second];
                --second;
            }

            carry = sum >>1;
            sum = sum & 1;

            result[i] = sum;
        }

        for(int i=0; i < result.length; i++){
            System.out.print(result[i]+", ");
        }

    }

    public static String binaryAddition2(String s1, String s2) {
       if(s1 == null && s2 == null) return "";
        int first = s1.length()-1;
        int second = s2.length()-1;
        StringBuffer sb = new StringBuffer();
        int carry = 0;

        while(first >=0 || second >=0){
            int sum = carry;
            if(first >= 0){
                sum += s1.charAt(first) - '0';
                --first;
            }
            if(second >= 0){
                sum += s2.charAt(second) - '0';
                --second;
            }
            carry = sum >> 1;
            sum = sum &1;
            sb.append(sum);
        }
        sb.append(carry);
       return sb.reverse().toString();
    }

    public static String binaryAddition(String s1, String s2) {
        if (s1 == null || s2 == null) return "";
        int first = s1.length() - 1;
        int second = s2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (first >= 0 || second >= 0) {
            int sum = carry;
            if (first >= 0) {
                sum += s1.charAt(first) - '0';
                first--;
            }
            if (second >= 0) {
                sum += s2.charAt(second) - '0';
                second--;
            }
            carry = sum >> 1;
            sum = sum & 1;
            sb.append(sum == 0 ? '0' : '1');
        }
        if (carry > 0)
            sb.append('1');

        sb.reverse();
        System.out.println(sb.toString());

        return String.valueOf(sb);
    }

}

package com.algos.dynamic;

import java.util.*;

/**
 * Created by pradeep on 17/09/2015.
 */
public class Int {


    public static void main(String[] args){

         formatP(")(a(b))((c)");
    }


    public static void formatP(String str){

        if(str ==null || str.length() ==0) return;

        Stack<Integer> stack = new Stack<Integer>();

        StringBuffer result = new StringBuffer();


        for(int i=0; i< str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){
                stack.add(i);
            }else if( c == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    stack.add(i);
                }

            }

        }


        for(int i = str.length()-1; i>=0; --i){
            int tmp = stack.peek();
            if(tmp == i){
                stack.pop();
            }else{
                result.append(str.charAt(i));
            }

        }

        System.out.println(result.reverse().toString());
    }


    public static void formatParenthesis(String str){

        if(str ==null || str.length() ==0) return;

        Stack<Integer> stack = new Stack();

        StringBuffer result = new StringBuffer();


        for(int i=0; i< str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){
                stack.push(i);
            }else if( c == ')'){
                if(!stack.empty()){
                    stack.pop();
                }else{
                    stack.push(i);
                }

            }

        }


        for(int i =0; i < str.length() ; i++){
            if(!stack.isEmpty()){
                int  t = stack.peek();
                if(t != i ){
                    result.append(str.charAt(i)+"");
                }else{
                    stack.pop();
                }
            }else{
                result.append(str.charAt(i)+"");
            }
        }
        System.out.println(result.toString());
    }






}

package com.algos.dynamic;

import java.util.*;

/**
 * Created by pradeep on 17/09/2015.
 */
public class Int {


    public static void main(String[] args){

         formatParenthesis("(()");
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
                stack.pop();
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

package com.algos.dynamic;

/**
 */
public class CandyProblem {


    public static void main(String... args) throws Exception{
/*        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<Integer> list = new ArrayList<Integer>();
        while((line = br.readLine()) != null){
            list.add(Integer.valueOf(line));
        }
        list.toArray();*/

      //  Integer[] arr = new Integer[list.size()];

        Integer[] arr = new Integer[]{2,4,2,6,1,7,8,9,2,1};

        System.out.println(candyCount(10, arr));
    }


    public static int candyCount(int n , Integer[] ratings){
        int count =0;
        int prev =0;
        int[] arr = new int[ratings.length];
        if(n <=0){
            return count;
        }else {
            count = 1;
            prev  =1;
        }

        arr[0] = 1;

        for(int i = 1; i < ratings.length; i++){
/*            if(ratings[i-1] == ratings[i]){
                count += 1;
            }else if(ratings[i-1] < ratings[i]){
                prev +=1 ;
                count +=prev;
            }else if(ratings[i-1]> ratings[i]){
               // prev -=1 ;
                count +=1;
            }
            arr[i] = prev;*/
            if(ratings[i] > ratings[i-1]){
                arr[i] = arr[i-1] +1 ;
            }else if (ratings[i] < ratings[i-1]){
                arr[i] = arr[i-1] -1;
            } else{

            }
        }
        for(int i =0 ; i < arr.length; i++)
            System.out.print(arr[i]+", ");
        return count;
    }
}

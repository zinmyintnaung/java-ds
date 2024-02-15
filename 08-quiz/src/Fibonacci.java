// each number is the sum of the preceeding two.
// For example, the sequence
//  [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]

import java.util.Arrays;

public class Fibonacci {

    public static int[] fib(int num){
        int[] sum = new int[num];

        for(int i=0; i < num; i++){
            if( i > 1){
                sum[i] = sum[i-1] + sum[i-2];
            }else{
                sum[i] = i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fib( 10)));
    }
}

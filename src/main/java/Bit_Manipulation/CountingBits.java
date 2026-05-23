package Bit_Manipulation;

// Leetcode 338

public class CountingBits {

    public static void main(String[] args) {
        int n = 15;

        int[] ans = countBits(n);
        for(int i : ans){
            System.out.print(i + " ");
        }
        System.out.println();

        int[] ans2 = countBitsOptimized(n);
        for(int i : ans2){
            System.out.print(i + " ");
        }
    }

    //Brute Force - Using recursive funciton
   public static int[] countBits(int num) {
        int[] ans  = new int[num+1];

        for(int i = 0; i <= num; i++) {
            ans[i] = rec(i);
        }
        return ans;
    }

    public static int rec(int num){
        if(num == 0) return 0;
        if(num == 1) return 1;

        if (num%2 == 0) return rec(num/2);
        else return 1+ rec(num/2);
    }


    //optimized code
 public static int[] countBitsOptimized(int n) {
        int[] result = new int[n+1];
        for(int i=1; i<n+1; i++){
            if(i%2!=0){
                result[i]=1 + result[i/2];
            }else{
                result[i]=result[i/2];
            }
        }
        return result;
    }

}

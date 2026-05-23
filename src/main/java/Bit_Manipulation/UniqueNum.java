package Bit_Manipulation;


public class UniqueNum {

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4, 4, 5, 5};
        System.out.println("Unique number from array is: "+ uniqueNumber(arr));

    }

    public static int uniqueNumber(int[] nums){
        int res = 0;
        for(int num:nums){
            res ^= num;
        }
        return res;
    }
}

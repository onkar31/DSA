package Arrays.Easy;

//Problem Statement: You are given an array of integers, your task is to move all the zeros in the array to the end of the array and
// move non-negative integers to the front by maintaining their order.

public class MoveAllZeroes {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 0, 4, 5};
        //int[] result = moveZeroes(arr);
        int[] result = moveZeroesOptimal(arr);
        System.out.print("Array after moving zeroes: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    //Brute Force --> TC= O(N)  SC= O(N)
    public static int[] moveZeroes(int[] arr) {
        int[] temp = new int[arr.length];
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                temp[index] = arr[i];
                index++;
            }
        }
        for(int i = 0; i < arr.length; i++){
            arr[i] = temp[i];
        }
        return arr;
    }

    //Optimal solution --> TC= O(N)  SC= O(1)
    public static int[] moveZeroesOptimal(int[] arr) {
        int j = -1;

        //Find the first zero
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        //If no zero found, return
        if (j == -1) return arr;

        //Start from next index of first zero
        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                //swap the nums
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                //move j to the next zero
                j++;
            }
        }
        return arr;
    }
}

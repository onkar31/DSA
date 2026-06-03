package JavaStreams.Phase1_Basics;

import java.util.List;

public class OddEven {

    public static void main(String[] args) {
        List<Integer> nums = List.of(1,2,3,4,5,6);
        evenNum(nums);
        oddNum(nums);
        numGreaterThan3(nums);
        countEvenNumbers(nums);
    }

//    Return All Even Numbers
    public static void evenNum(List<Integer> nums) {
        List<Integer> evenNumbers = nums.stream()
                .filter(n -> n  % 2 == 0)
                .toList();
        System.out.println("Even Numbers: "+evenNumbers);
    }

//    Return All Odd Numbers
    public static void oddNum(List<Integer> nums) {
        List<Integer> oddNumbers = nums.stream()
                .filter(n -> n  % 2 != 0)
                .toList();
        System.out.println("Odd Numbers: "+oddNumbers);
    }

//    Return numbers greater than 3.
public static void numGreaterThan3(List<Integer> nums) {
    List<Integer> greaterNums = nums.stream()
            .filter(n -> n  > 3)
            .toList();
    System.out.println("Numbers Greater than 3: "+greaterNums);
}

//    Count even numbers.
public static void countEvenNumbers(List<Integer> nums) {
       long evenNumCount  = nums.stream()
               .filter(n -> n  % 2 == 0)
               .count();
    System.out.println("Even Numbers Count: "+evenNumCount);
}
}

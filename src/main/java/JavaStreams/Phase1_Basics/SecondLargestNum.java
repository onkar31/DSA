package JavaStreams.Phase1_Basics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondLargestNum {

    public static void main(String[] args) {
        List<Integer> nums = List.of(10, 20, 5, 40, 40, 30);
        getSecondLargestNum(nums);
        getSecondSmallestNum(nums);

        List<String> word = List.of("java", "spring", "sql", "Microservices");
        getSecondLargestWord(word);


        List<Integer> singleEle = List.of(10);
        getSecondLargNumFromSigleElementList(singleEle);


        List<MinMax.Employee> employees = Arrays.asList(
                new MinMax.Employee(1, "John", 30000),
                new MinMax.Employee(2, "Ram", 40000),
                new MinMax.Employee(3, "Chamya", 80000)
        );
        getSecondHishestSalary(employees);
    }

    // Find Second Largest Number  [Time complexity: O(n log n)]
    public static void getSecondLargestNum(List<Integer> nums) {
        int secondLargest = nums.stream()
                .distinct()                 //handles duplicate nums
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow();
        System.out.println("Second Largest Num: "+secondLargest);
    }

    // Find Second Largest Number --> List contain only one element
    public static void getSecondLargNumFromSigleElementList(List<Integer> nums) {
        Integer secondLargest = nums.stream()
                .distinct()                 //handles duplicate nums
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("Second Largest Num from Single element list: "+secondLargest);
    }


    // Find Second smallest Number
    public static void getSecondSmallestNum(List<Integer> nums) {
        Integer secondSmallest = nums.stream()
                .distinct()                 //handles duplicate nums
                .sorted()
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("Second Smallest Num: "+secondSmallest);
    }

    // Find Second largest word
    public static void getSecondLargestWord(List<String> word) {
        String secondLargestWord = word.stream()
                .distinct()                 //handles duplicate nums
                .sorted(Comparator.comparing(String::length).reversed())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("Second Largest Word: "+secondLargestWord);
    }


    // Find Second employee with second highest salary
    public static void getSecondHishestSalary(List<MinMax.Employee> employees) {
        MinMax.Employee emp = employees.stream()
                .sorted(Comparator.comparing(MinMax.Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("Second Smallest Num: "+emp);
    }


}

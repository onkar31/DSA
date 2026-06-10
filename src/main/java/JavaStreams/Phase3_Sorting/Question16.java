package JavaStreams.Phase3_Sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Question16 {

    public static void main(String[] args) {
        List<Integer> nums = List.of(5, 1, 8, 3, 2);
        ascendingSort(nums);
        descendingSort(nums);

        List<Integer> numbers = List.of(5, 1, 8, 5, 2, 3, 2);
        descendingSortAndRemoveDuplicates(numbers);
        top3Nums(numbers);
    }

    // Default sort -> Ascending sort
    public static void ascendingSort(List<Integer> nums) {
        List<Integer> sortedNums = nums.stream()
                .sorted().toList();
        System.out.println(sortedNums);
    }

    //Descending sort
    public static void descendingSort(List<Integer> nums) {
        List<Integer> sortedNums = nums.stream()
//                .sorted((a,b) -> Integer.compare(b,a)).toList();
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(sortedNums);
    }

    //Sort and remove duplicates
    public static void descendingSortAndRemoveDuplicates(List<Integer> nums) {
        List<Integer> result = nums.stream()
                .distinct()
                .sorted(Comparator.reverseOrder()).toList();
        System.out.println(result);
    }

    //Find top 3 numbers
    public static void top3Nums(List<Integer> nums) {
        List<Integer> result = nums.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                        .limit(3)
                                .toList();
        System.out.println("Top 3 numbers: "+result);
    }
}

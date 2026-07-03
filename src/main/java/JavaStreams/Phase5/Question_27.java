package JavaStreams.Phase5;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question_27 {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(3, 4, 5, 6, 7);

        getCommonElements(list1, list2);
        getCommonElementsOptimized(list1, list2);
    }

    //Find Common elements between 2 lists  --> TC O(n * m)
    public static void getCommonElements(List<Integer> list1, List<Integer> list2 ) {
        List<Integer> result = list1.stream()
                .filter(list2::contains)
                .toList();
        System.out.println(result);
    }

    //Find Common elements between 2 lists using Set --> TC O(n + m)
    public static void getCommonElementsOptimized(List<Integer> list1, List<Integer> list2 ) {
        Set<Integer> set = new HashSet<>(list2);
        List<Integer> result = list1.stream()
                .filter(set::contains)
                .distinct()     // To handle Duplicates
                .toList();
        System.out.println(result);
    }
}

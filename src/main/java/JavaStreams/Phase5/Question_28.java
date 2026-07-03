package JavaStreams.Phase5;

import java.util.List;
import java.util.stream.Stream;

public class Question_28 {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(3, 4, 5, 6);

        mergeLists(list1, list2);
    }

    //Merge 2 lists
    public static void mergeLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = Stream.concat(
                list1.stream(),
                list2.stream()
        )
                .distinct()
                .toList();
        System.out.println(result);
    }
}

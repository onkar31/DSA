package JavaStreams.Phase1_Basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RemoveNullStrings {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "", null, "spring", " ", "boot");
        List<String> list1 = Arrays.asList("java", "", "spring", " ");
        List<String> list2 = Arrays.asList("  java  ", "", "     React", " ");
        removeNulls(words);
        removeBlankStrings(list1);
        trimRemoveBlankStrings(list2);
    }

//    Remove Empty/Blank Strings
    public static void removeNulls(List<String> words) {
        List<String> result = words.stream()
                .filter(Objects::nonNull)
//                .filter(s -> !s.trim().isEmpty())
                .filter(s -> !s.isBlank())      // isBlank() introduced in java 11
                .toList();
        System.out.println(result);
    }

//    Remove blank strings.
    public static void removeBlankStrings(List<String> words) {
        List<String> result = words.stream()
                .filter(s->!s.isBlank())
                .toList();
        System.out.println(result);
    }

//    Trim all strings and remove blanks.
    public static void trimRemoveBlankStrings(List<String> words) {
        List<String> result = words.stream()
                .filter(s->!s.isBlank())
                .map(String::trim)
                .toList();
        System.out.println(result);
    }
}

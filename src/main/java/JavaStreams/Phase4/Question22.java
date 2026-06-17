package JavaStreams.Phase4;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Question22 {
    public static void main(String[] args) {
        List<String> words = List.of("java", "spring", "java", "sql", "spring", "java");
        getWordFreq(words);
        findMostFreqWord(words);
    }

    // Count frequency of word
    public static void getWordFreq(List<String> words) {
        Map<String, Long> wordFreq = words.stream()
                .collect(
//                        Collectors.groupingBy(word -> word, Collectors.counting())
                        Collectors.groupingBy(Function.identity(), Collectors.counting())
                );
        System.out.println(wordFreq);
    }

    // Count most frequency word
    public static void findMostFreqWord(List<String> words) {
        String mostFreq = words.stream()
                .collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting())
                ).entrySet()
                        .stream()
                                .max(Map.Entry.comparingByValue())
                                        .map(Map.Entry::getKey)
                                                .orElse(null);
        System.out.println(mostFreq);
    }
}

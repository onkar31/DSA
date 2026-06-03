package JavaStreams;

public class StreamsOverview {

/*
-----------------PHASE 1 — BASICS---------------------

  1. Return all even numbers from a list
     list.stream()
        .filter(n -> n % 2 == 0)
        .toList();

2. Convert a list of strings to uppercase
    list.stream()
        .map(String::toUpperCase)
        .toList();

3. Remove empty/null strings
    list.stream()
        .filter(s -> s != null && !s.isEmpty())
        .toList();

4. Count how many elements start with a given letter
    list.stream()
        .filter(s -> s.startsWith("A"))
        .count();

5. Find min & max
    list.stream().min(Integer::compare).get();
    list.stream().max(Integer::compare).get();

6. Sum all integers using reduce
    int sum = list.stream().reduce(0, Integer::sum);

7. Find second-largest number
    list.stream()
        .sorted(Comparator.reverseOrder())
        .skip(1)
        .findFirst()
        .get();

8. First non-repeating character in a string
    char c = str.chars()
        .mapToObj(i -> (char)i)
        .collect(Collectors.groupingBy(ch -> ch, LinkedHashMap::new, Collectors.counting()))
        .entrySet().stream()
        .filter(e -> e.getValue() == 1)
        .map(Map.Entry::getKey)
        .findFirst()
        .get();

--------------------PHASE 2 — FILTERING & MAPPING--------------------

9. Get employees with salary > X
    list.stream()
        .filter(e -> e.getSalary() > X)
        .toList();

10. Extract only names
    list.stream()
        .map(Employee::getName)
        .toList();

11. Return palindrome words
    list.stream()
        .filter(w -> new StringBuilder(w).reverse().toString().equals(w))
        .toList();

12. Remove duplicates
    list.stream().distinct().toList();

13. Filter strings containing substring
    list.stream()
        .filter(s -> s.contains("abc"))
        .toList();

14. Remove words with length < 3
    list.stream()
        .filter(s -> s.length() >= 3)
        .toList();

15. Sort names by length
    list.stream()
        .sorted(Comparator.comparing(String::length))
        .toList();

------------------------PHASE 3 — SORTING------------------------

16. Sort integers in descending
    list.stream()
        .sorted(Comparator.reverseOrder())
        .toList();

17. Sort employees by salary → then age
    list.stream()
        .sorted(Comparator.comparing(Employee::getSalary)
                      .thenComparing(Employee::getAge))
        .toList();

18. Sort strings alphabetically ignoring case
    list.stream()
        .sorted(String.CASE_INSENSITIVE_ORDER)
        .toList();

19. Multi-field sorting with custom comparator
    list.stream()
        .sorted(Comparator.comparing(Employee::getDept)
        .thenComparing(Employee::getSalary).reversed())
        .toList();

------------------------ PHASE 4 — GROUPING ------------------------

20. Group words by first letter
    list.stream()
        .collect(Collectors.groupingBy(s -> s.charAt(0)));

21. Group employees by department
    list.stream()
    .collect(Collectors.groupingBy(Employee::getDept));

22. Word frequency
    list.stream()
    .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

23. Highest salary per department
    list.stream()
    .collect(Collectors.groupingBy(
        Employee::getDept,
        Collectors.collectingAndThen(
            Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
            Optional::get
        )
    ));

24. Group students by grade (names only)
    list.stream()
    .collect(Collectors.groupingBy(
        Student::getGrade,
        Collectors.mapping(Student::getName, Collectors.toList())
    ));

------------------------ PHASE 5 — ADVANCED OPERATIONS ------------------------

25. Flatten list of lists using flatMap
    listOfLists.stream()
    .flatMap(List::stream)
    .toList();

26. Convert list → comma-separated string
    String s = list.stream()
    .collect(Collectors.joining(","));

27. Find common elements between two lists
    list1.stream()
    .filter(list2::contains)
    .toList();

28. Merge two lists & remove duplicates
    Stream.concat(list1.stream(), list2.stream())
    .distinct()
    .toList();

29. Partition list into even/odd
    list.stream()
    .collect(Collectors.partitioningBy(n -> n % 2 == 0));

30. Convert list → map (id → object)
    list.stream()
    .collect(Collectors.toMap(Employee::getId, e -> e));

31. Convert list → map (name → salary)
    list.stream()
    .collect(Collectors.toMap(Employee::getName, Employee::getSalary));



*/
}

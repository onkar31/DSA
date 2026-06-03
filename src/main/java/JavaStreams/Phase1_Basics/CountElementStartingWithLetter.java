package JavaStreams.Phase1_Basics;

import java.util.List;

public class CountElementStartingWithLetter {

    public static void main(String[] args) {
        List<String> names = List.of("Alice","Ankita","Bobbie","Alex","ChArlie");
        List<String> names1 = List.of("Alice","ankit","Bob","anuv","ChArlie");
        List<String> emails = List.of("Alice@a.com","@nkit","B@b.com","anuv","ChArlie");
        countLetter(names);
        countLetter1(names1);
        countNames(names);
        countValidEmails(emails);
        anyMatch(names);
        allMatch(names);
        noneMatch(names);
    }

//    Count Elements Starting With a Given Letter - "A"
    public static void countLetter(List<String> names) {
        long countLetter = names.stream()
                .filter(name -> name.startsWith("A"))
                .count();
        System.out.println(countLetter);
    }

//    Count names starting with "a" or "A".
    public static void countLetter1(List<String> names) {
        long countLetter = names.stream()
            .filter(name -> name.startsWith("A") || name.toLowerCase().startsWith("a"))
            .count();
        System.out.println(countLetter);
    }

//    Count names longer than 5
    public static void countNames(List<String> names) {
        long countName = names.stream()
            .filter(name -> name.length() > 5)
            .count();
        System.out.println(countName);
    }

//    Count valid emails
    public static void countValidEmails(List<String> emails) {
        long validEmails = emails.stream()
            .filter(name -> name.contains("@"))
            .count();
        System.out.println("Valid Emails: "+validEmails);
    }

    //Stream short circuiting
    //whether at least one name exists which starts with "A"
    public static void anyMatch(List<String> names) {
        boolean exists = names.stream()
                        .anyMatch(name -> name.startsWith("A"));
        System.out.println("Name starts with A exists in the list: "+exists);
    }

    // allMatch
    public static void allMatch(List<String> names) {
        boolean checkLength = names.stream()
                .anyMatch(name -> name.length() > 2);
        System.out.println("All names length are greater than 2: "+checkLength);
    }

    // noneMatch
    public static void noneMatch(List<String> names) {
        boolean checkListIsNotEmpty = names.stream()
                .anyMatch(name -> !name.isBlank());
        System.out.println("list is not blank: "+checkListIsNotEmpty);
    }

}

package String.easy;

import java.util.Stack;

public class ReverseWord {
    public static void main(String[] args) {
        String input = "Hello World";
        String output = reverseWordsUsingStringBuilder(input);
        System.out.println(output);

        String output_stack = reverseWordsUsingStack(input);
        System.out.println(output_stack);
    }

    //Approach 1
    public static String reverseWordsUsingStringBuilder(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if(i !=0){
                result.append(" ");
            }
        }
        return result.toString();
    }

    //Approach 2
    public static String reverseWordsUsingStack(String s) {
        String[] words = s.trim().split("\\s+");
        Stack<String> stack = new Stack<>();
        for(String word : words){
            stack.push(word);
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()){
            result.append(stack.pop());
            if(!stack.isEmpty()){
                result.append(" ");
            }
        }
        return result.toString();
    }
}

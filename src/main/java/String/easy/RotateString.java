package String.easy;

public class RotateString {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";
        boolean result = rotateStrig(s, goal);
        System.out.println(result);
    }

    public static boolean rotateStrig(String s, String goal) {
        if(s.length()!= goal.length()) return false;
        return (s + s).contains(goal);
    }
}

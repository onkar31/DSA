package leetcode;

public class PalindromeNumber {
    public static void main(String[] args) {
        int x = 12321;
        boolean isPalindrome = isPalindrome(x);
        System.out.println(isPalindrome);
    }

    public static boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;

        int reversed_int = 0;
        while (x > reversed_int) {
            int pop = x % 10;
             x /= 10;
             reversed_int = (reversed_int * 10) + pop;
        }

        if (x == reversed_int || x == reversed_int/10) return true;
        return false;
    }
}

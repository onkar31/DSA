package String;

public class Palindrome {

    public static void main(String[] args) {
        String str = "madam";
        System.out.println(isPalindromeBruteForce(str));

        String str1 = "A man, a plan, a canal: Panama";
        String cleaned = str1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(isPalindrome(cleaned));
    }

    public static boolean isPalindromeBruteForce(String str) {
        return new StringBuffer(str).reverse().toString().equals(str);
    }

    //Optimal way
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

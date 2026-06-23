package leetcode;

public class RotateString {
    public static void main(String[] args) {
        String a = "abcde";
        String b = "cdeab";
        boolean flag = rotateString(a,b);
        System.out.println(flag);
    }

    public static  boolean rotateString(String str1,String str2) {
        return (str1.length() == str2.length() && (str1 + str1).contains(str2));
    }
}

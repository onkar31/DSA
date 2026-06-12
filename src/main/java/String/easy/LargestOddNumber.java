package String.easy;

public class LargestOddNumber {
    public static void main(String[] args) {
        String num = "34520";
        String oddNum = getLargestOddNum(num);
        System.out.println(oddNum);
    }

    public static String getLargestOddNum(String num) {
        for (int i = num.length() -1; i >= 0; i--) {
            char ch = num.charAt(i);
            if((ch - '0') % 2 != 0){
                return num.substring(0, i+1);
            }
        }
        return "";
    }
}

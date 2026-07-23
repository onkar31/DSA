package leetcode;

public class RepeatedSubstring {
    public static void main(String[] args) {
        String s = "abcabcabcabc";
        System.out.println(repeatedSubstring(s));
    }

    public static boolean repeatedSubstring(String s) {
        int len = s.length();
        for(int i = len/2; i >=1 ; i--){
            if(len % i == 0){
                int num_repeats = len / i;
                String substring = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < num_repeats; j++){
                    sb.append(substring);
                }
                if(sb.toString().equals(s)) return true;
            }
        }
        return false;
    }
}

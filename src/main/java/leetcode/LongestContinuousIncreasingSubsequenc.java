package leetcode;

public class LongestContinuousIncreasingSubsequenc {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4 , 7};
        System.out.println(lengthOfLongestSubstring(arr));
    }

    public static int lengthOfLongestSubstring(int[] num) {
        int res = 0;
        int anchor = 0;

        for(int i = 0; i < num.length; i++){
            if(i > 0 && num[i -1] >= num[i]){
                anchor = i;
            }
            res = Math.max(res, i - anchor + 1);
        }
        return res;
    }
}

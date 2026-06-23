package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4, 11, 111};
        boolean haveDuplicates = containsDuplicate(nums);
        System.out.println(haveDuplicates);
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

    // Using array inbuilt method -> Space complexity O(1)
    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] == nums[i+1]) return true;
        }
        return false;
    }

}

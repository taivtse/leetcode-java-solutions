package array.two_pointers;

import java.util.Arrays;

/**
 * @author taivt
 * @link https://leetcode.com/problems/two-sum-less-than-k/
 * @since 2022/05/03 00:54:05
 */
public class LC1099_TwoSumLessThanK {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.twoSumLessThanK(new int[]{34, 23, 1, 24, 75, 33, 54, 8}, 60));
        System.out.println(solution.twoSumLessThanK(new int[]{254, 914, 110, 900, 147, 441, 209, 122, 571, 942, 136, 350, 160, 127, 178, 839, 201, 386, 462, 45, 735, 467, 153, 415, 875, 282, 204, 534, 639, 994, 284, 320, 865, 468, 1, 838, 275, 370, 295, 574, 309, 268, 415, 385, 786, 62, 359, 78, 854, 944}, 200));
    }

    private static class Solution {
        public int twoSumLessThanK(int[] nums, int k) {
            Arrays.sort(nums);
            int l = 0, r = nums.length - 1;
            int res = -1;
            while (l < r) {
                int twoSum = nums[l] + nums[r];
                if (twoSum < k) {
                    res = Math.max(twoSum, res);
                    l++;
                } else {
                    r--;
                }
            }
            return res;
        }
    }
}

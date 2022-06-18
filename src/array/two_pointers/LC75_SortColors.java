package array.two_pointers;

import java.util.Arrays;

/**
 * @author taivt
 * @link https://leetcode.com/problems/sort-colors/
 * @since 2022/03/14 22:24:38
 */
public class LC75_SortColors {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {2, 0, 1};
        solution.sortColors(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    // Space Complexity: O(1)
    // Time Complexity: O(n)
    private static class Solution {
        public void sortColors(int[] nums) {
            int numOfRed = 0;
            int numOfWhite = 0;
            for (int num : nums) {
                if (num == 0) {
                    numOfRed++;
                } else if (num == 1) {
                    numOfWhite++;
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (i < numOfRed) {
                    nums[i] = 0;
                } else if (i < numOfRed + numOfWhite) {
                    nums[i] = 1;
                } else {
                    nums[i] = 2;
                }
            }
        }
    }
}

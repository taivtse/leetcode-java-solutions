package array.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author taivt
 * @link https://leetcode.com/problems/3sum/
 * @since 2022/04/19 21:29:20
 */
public class LC15_3Sum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum(new int[]{-2, 0, 1, 1, 2}));
    }

    // Space Complexity: O(n)
    // Time Complexity: O(n ^ 2)
    private static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
                if (i > 0 && nums[i - 1] == nums[i]) {
                    // ignore duplicate triplets
                    continue;
                }
                twoSum(nums, i, result);
            }
            return result;
        }

        private void twoSum(int[] nums, int curI, List<List<Integer>> result) {
            int l = curI + 1, r = nums.length - 1;
            while (l < r) {
                int twoSum = nums[curI] + nums[l] + nums[r];
                if (twoSum < 0) {
                    l++;
                } else if (twoSum > 0) {
                    r--;
                } else {
                    result.add(List.of(nums[curI], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l - 1] == nums[l]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
            }
        }
    }
}

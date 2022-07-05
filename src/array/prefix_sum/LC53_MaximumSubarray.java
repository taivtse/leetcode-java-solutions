package array.prefix_sum;

/**
 * @author taivt
 * @link https://leetcode.com/problems/maximum-subarray/
 * @since 2022/06/26 21:25:22
 */
public class LC53_MaximumSubarray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solution.maxSubArray(new int[]{1}));
        System.out.println(solution.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution {
        public int maxSubArray(int[] nums) {
            int[] prefixSum = new int[nums.length];
            prefixSum[0] = nums[0];
            for (int i = 1; i < prefixSum.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }

            int maxSum = Integer.MIN_VALUE;
            int minSoFar = 0;
            for (int i = 0; i < prefixSum.length; i++) {
                maxSum = Math.max(maxSum, prefixSum[i] - minSoFar);
                minSoFar = Math.min(minSoFar, prefixSum[i]);
            }
            return maxSum;
        }
    }
}

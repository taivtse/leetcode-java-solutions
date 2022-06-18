package array.prefix_sum;

/**
 * @author taivt
 * @link https://leetcode.com/problems/range-sum-query-immutable/
 * @since 2022/03/14 20:54:33
 */
public class LC303_RangeSumQueryImmutable {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println("Sum from 0 -> 2 = " + numArray.sumRange(0, 2));
        System.out.println("Sum from 2 -> 5 = " + numArray.sumRange(2, 5));
        System.out.println("Sum from 0 -> 5 = " + numArray.sumRange(0, 5));
    }

    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class NumArray {
        private final int[] prefixSum;

        public NumArray(int[] nums) {
            prefixSum = new int[nums.length];
            prefixSum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0) {
                return prefixSum[right];
            }
            return prefixSum[right] - prefixSum[left - 1];
        }
    }
}

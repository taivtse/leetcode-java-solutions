package array.sliding_window;

/**
 * @author taivt
 * @problem 713. Subarray Product Less Than K
 * @link https://leetcode.com/problems/subarray-product-less-than-k/
 * @submission https://leetcode.com/problems/subarray-product-less-than-k/submissions/934625805/
 * @difficulty Medium
 * @tags Array, Sliding Window
 * @since 2023/03/12 16:20:03
 */
public class LC713_SubarrayProductLessThanK {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    System.out.println(solution.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
    System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 5, 3, 2, 6}, 100));
    System.out.println(solution.numSubarrayProductLessThanK(new int[]{1, 2, 3, 4, 5}, 100));
    System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 9, 10, 4, 3, 8}, 19));
    System.out.println(solution.numSubarrayProductLessThanK(new int[]{57, 44, 92, 28, 66, 60, 37, 33, 52, 38, 29, 76, 8, 75, 22}, 18));
  }

  /*
   * Space complexity: O(1)
   * Time complexity: O(n)
   */
  private static class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
      if (k <= 1) {
        return 0;
      }
      int count = 0;
      int l = 0;
      int r = 1;
      int product = nums[l];
      int length = nums.length;

      while (l < r) {
        while (r < length && product < k) {
          product *= nums[r];
          r++;
        }
        if (product >= k) {
          count += r - l - 1;
        } else {
          count += r - l;
        }

        product /= nums[l];
        l++;
        if (l == r && r < length) {
          r++;
          product *= nums[l];
        }
      }

      return count;
    }
  }

}

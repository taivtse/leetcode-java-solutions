package array.two_pointers;

import java.util.Arrays;

/**
 * @author taivt
 * @link https://leetcode.com/problems/move-zeroes/
 * @since 2022/03/14 21:13:06
 */
public class LC283_MoveZeroes {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = {0, 1, 0, 3, 12};
    solution.moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }

  // Space Complexity: O(1)
  // Time Complexity: O(n)
  private static class Solution {
    public void moveZeroes(int[] nums) {
      int cur = 0;
      int nextNonZeroIdx = 1;

      while (nextNonZeroIdx < nums.length) {
        if (nums[cur] == 0) {
          // Move nextNonZeroIdx to the right
          while (nextNonZeroIdx < nums.length) {
            // Found a non-zero element
            if (nums[nextNonZeroIdx] != 0) {
              nums[cur] = nums[nextNonZeroIdx];
              nums[nextNonZeroIdx] = 0;
              break;
            }
            nextNonZeroIdx++;
          }
        }
        cur++;
        nextNonZeroIdx++;
      }
    }
  }
}

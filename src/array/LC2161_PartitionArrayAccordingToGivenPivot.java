package array;

import java.util.Arrays;

/**
 * @author taivt
 * @problem 2161. Partition Array According to Given Pivot
 * @link https://leetcode.com/problems/partition-array-according-to-given-pivot/
 * @submission https://leetcode.com/problems/partition-array-according-to-given-pivot/submissions/945454177/
 * @difficulty Medium
 * @tags Array, Two Pointers, Simulation
 * @since 2023/05/06 17:03:48
 */
public class LC2161_PartitionArrayAccordingToGivenPivot {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10)));
    System.out.println(Arrays.toString(solution.pivotArray(new int[]{-3, 4, 3, 2}, 2)));
  }

  /*
   * Space complexity: O(n)
   * Time complexity: O(n)
   */
  private static class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
      int lowCount = 0;
      int highCount = 0;
      for (int num : nums) {
        if (num < pivot) {
          lowCount++;
        } else if (num > pivot) {
          highCount++;
        }
      }

      int lowIdx = 0;
      int pivotIdx = lowCount;
      int highIdx = nums.length - highCount;
      int[] result = new int[nums.length];
      for (int num : nums) {
        if (num < pivot && lowCount >= 0) {
          result[lowIdx] = num;
          lowIdx++;
          lowCount--;
        } else if (num > pivot && highCount >= 0) {
          result[highIdx] = num;
          highIdx++;
          highCount--;
        } else {
          result[pivotIdx] = num;
          pivotIdx++;
        }
      }

      return result;
    }
  }
}

package binary_search;

import java.util.Arrays;

/**
 * @author taivt
 * @problem 34. Find First and Last Position of Element in Sorted Array
 * @link https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @submission https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/968927272/
 * @difficulty Medium
 * @tags Array, Binary Search
 * @since 2023/06/11 21:26:16
 */
public class LC34_FindFirstAndLastPositionOfElementInSortedArray {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
    System.out.println(Arrays.toString(solution.searchRange(new int[]{}, 0)));
  }

  /*
   * Space complexity: O(1)
   * Time complexity: O(log(n))
   */
  private static class Solution {
    public int[] searchRange(int[] nums, int target) {
      int lowerBound = findLowerBound(nums, target);
      int higherBound = findHigherBound(nums, target);

      return new int[]{lowerBound, higherBound};
    }

    private int findHigherBound(int[] nums, int target) {
      if (nums.length == 0) {
        return -1;
      }
      int left = 0;
      int right = nums.length - 1;
      int higherBound = 0;

      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] <= target) {
          higherBound = mid;
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }

      return nums[higherBound] == target ? higherBound : -1;
    }

    private int findLowerBound(int[] nums, int target) {
      if (nums.length == 0) {
        return -1;
      }
      int left = 0;
      int right = nums.length - 1;
      int lowerBound = 0;

      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] >= target) {
          lowerBound = mid;
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }

      return nums[lowerBound] == target ? lowerBound : -1;
    }
  }
}

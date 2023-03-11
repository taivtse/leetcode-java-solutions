package array;

/**
 * @author taivt
 * @link https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/
 * @submission https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/submissions/882953189/
 * @difficulty Easy
 * @tags Array, Sorting
 * @since 2023/01/22 15:00:26
 */
public class LC2148_CountElementsWithStrictlySmallerAndGreaterElements {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.countElements(new int[]{11, 7, 2, 15}));
    System.out.println(solution.countElements(new int[]{-3, 3, 3, 90}));
    System.out.println(solution.countElements(new int[]{1, 1, 1, 1, 1, 1}));
    System.out.println(solution.countElements(new int[]{90, -1, 8, 5, 7}));
  }

  // Space Complexity: O(1)
  // Time Complexity: O(n)
  private static class Solution {
    public int countElements(int[] nums) {
      int min = Integer.MAX_VALUE;
      int minCount = 0;
      int max = Integer.MIN_VALUE;
      int maxCount = 0;

      for (int num : nums) {
        // Find min
        if (num < min) {
          min = num;
          minCount = 1;
        } else if (num == min) {
          minCount++;
        }

        // Find max
        if (num > max) {
          max = num;
          maxCount = 1;
        } else if (num == max) {
          maxCount++;
        }
      }

      // Count elements
      if (min == max) {
        return 0;
      } else {
        return nums.length - (minCount + maxCount);
      }
    }
  }
}

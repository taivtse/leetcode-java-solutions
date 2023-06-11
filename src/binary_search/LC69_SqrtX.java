package binary_search;

/**
 * @author taivt
 * @problem 69. Sqrt(x)
 * @link https://leetcode.com/problems/sqrtx/description/
 * @submission https://leetcode.com/problems/sqrtx/submissions/968960883/
 * @difficulty Easy
 * @tags Math, Binary Search
 * @since 2023/06/11 22:32:26
 */
public class LC69_SqrtX {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.mySqrt(4));
    System.out.println(solution.mySqrt(8));
  }

  /*
   * Space complexity: O(1)
   * Time complexity: O(log(x))
   */
  private static class Solution {
    public int mySqrt(int x) {
      int low = 0;
      int high = x;
      int ans = 0;
      while (low <= high) {
        int mid = low + (high - low) / 2;
        long powerOf2 = (long) mid * mid;
        if (powerOf2 < x) {
          ans = mid;
          low = mid + 1;
        } else if (powerOf2 == x) {
          return mid;
        } else {
          high = mid - 1;
        }
      }
      return ans;
    }
  }
}

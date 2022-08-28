package bit_manipulation;

/**
 * @author taivt
 * @link https://leetcode.com/problems/power-of-two/
 * @since 2022/03/13 23:40:23
 */
public class LC231_PowerOfTwo {
  public static void main(String[] args) {
    System.out.println("Example 1: " + new Solution().isPowerOfTwo(1));
    System.out.println("Example 2: " + new Solution().isPowerOfTwo(16));
    System.out.println("Example 3: " + new Solution().isPowerOfTwo(3));
    System.out.println("Example 4: " + new Solution().isPowerOfTwo(536870912));
    System.out.println("Example 5: " + new Solution().isPowerOfTwo(0));
    System.out.println("Example 6: " + new Solution().isPowerOfTwo(-1));
  }

  // Space Complexity: O(1)
  // Time Complexity: O(1)
  private static class Solution {
    public boolean isPowerOfTwo(int n) {
      if (n <= 0) {
        return false;
      }
      return (n & (n - 1)) == 0;
    }
  }
}

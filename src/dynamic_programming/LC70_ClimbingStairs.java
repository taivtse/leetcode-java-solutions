package dynamic_programming;

import java.util.Arrays;

/**
 * @author taivt
 * @link https://leetcode.com/problems/climbing-stairs/
 * @since 2022/06/05 21:41:38
 */
public class LC70_ClimbingStairs {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.climbStairs(2));
    System.out.println(solution.climbStairs(3));
  }

  private static class Solution {
    private final int[] f = new int[46];

    public int climbStairs(int n) {
      Arrays.fill(f, -1);
      return climbStairsRecursive(n);
    }

    private int climbStairsIterative(int n) {
      f[1] = 1;
      f[2] = 2;
      for (int i = 3; i <= n; i++) {
        f[i] = f[i - 1] + f[i - 2];
      }
      return f[n];
    }

    private int climbStairsRecursive(int n) {
      if (n == 1 || n == 2) {
        return n;
      }

      if (f[n] != -1) {
        return f[n];
      }

      int fn = climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
      f[n] = fn;
      return fn;
    }
  }
}

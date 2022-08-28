package array.prefix_sum;

/**
 * @author taivt
 * @link https://leetcode.com/problems/grid-game/
 * @since 2022/07/05 20:23:21
 */
public class LC2017_GridGame {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.gridGame(new int[][]{{2, 5, 4}, {1, 5, 1}}));
    System.out.println(solution.gridGame(new int[][]{{3, 3, 1}, {8, 5, 2}}));
    System.out.println(solution.gridGame(new int[][]{{1, 3, 1, 15}, {1, 3, 3, 1}}));
    System.out.println(solution.gridGame(new int[][]{{1}, {1}}));
  }

  // Space Complexity: O(1)
  // Time Complexity: O(n)
  private static class Solution {
    public long gridGame(int[][] grid) {
      long topSum = 0;
      for (int i = 0; i < grid[0].length; i++) {
        topSum += grid[0][i];
      }
      long bottomSum = 0;
      long ans = Long.MAX_VALUE;
      for (int i = 0; i < grid[0].length; i++) {
        topSum -= grid[0][i];
        ans = Math.min(ans, Math.max(topSum, bottomSum));
        bottomSum += grid[1][i];
      }
      return ans;
    }
  }

}

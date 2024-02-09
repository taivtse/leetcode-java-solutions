package array;

/**
 * @author taivt
 * @problem 883. Projection Area of 3D Shapes
 * @link https://leetcode.com/problems/projection-area-of-3d-shapes/description/
 * @submission https://leetcode.com/problems/projection-area-of-3d-shapes/submissions/1170807718/
 * @difficulty Easy
 * @tags Array, Math, Geometry, Matrix
 * @since 2024/02/10 00:17:30
 */
public class LC883_ProjectionAreaOf3DShapes {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.projectionArea(new int[][]{{1, 2}, {3, 4}}));
    System.out.println(solution.projectionArea(new int[][]{{2}}));
    System.out.println(solution.projectionArea(new int[][]{{1, 0}, {0, 2}}));
    System.out.println(solution.projectionArea(new int[][]{{1, 0}, {5, 4}}));
  }

  /*
   * Space complexity: TODO
   * Time complexity: TODO
   */
  private static class Solution {
    public int projectionArea(int[][] grid) {
      int xyCubes = 0;
      int yzCubes = 0;
      int zxCubes = 0;

      for (int i = 0; i < grid.length; i++) {
        int yzTallestTower = Integer.MIN_VALUE;
        int zxTallestTower = Integer.MIN_VALUE;
        for (int j = 0; j < grid[0].length; j++) {
          if (grid[i][j] != 0) {
            xyCubes++;
          }
          yzTallestTower = Math.max(yzTallestTower, grid[i][j]);
          zxTallestTower = Math.max(zxTallestTower, grid[j][i]);
        }
        yzCubes += yzTallestTower;
        zxCubes += zxTallestTower;
      }

      return xyCubes + yzCubes + zxCubes;
    }
  }
}

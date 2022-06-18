package dynamic_programming;

/**
 * @author taivt
 * @link https://leetcode.com/problems/minimum-falling-path-sum/
 * @since 2022/06/18 23:41:58
 */
public class LC931_MinimumFallingPathSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
        System.out.println(solution.minFallingPathSum(new int[][]{{-19, 57}, {-40, -5}}));
        System.out.println(solution.minFallingPathSum(new int[][]{{57}}));
    }

    // n: matrix.length
    // Space Complexity: O(1)
    // Time Complexity: O(n ^ 2)
    private static class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            for (int row = 1; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int min = matrix[row - 1][col];
                    if (col - 1 >= 0) {
                        min = Math.min(min, matrix[row - 1][col - 1]);
                    }
                    if (col + 1 < n) {
                        min = Math.min(min, matrix[row - 1][col + 1]);
                    }
                    matrix[row][col] += min;
                }
            }

            int minFallingSum = Integer.MAX_VALUE;
            for (int col = 0; col < n; col++) {
                minFallingSum = Math.min(minFallingSum, matrix[n - 1][col]);
            }
            return minFallingSum;
        }
    }
}

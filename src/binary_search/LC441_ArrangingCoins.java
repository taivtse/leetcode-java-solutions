package binary_search;

/**
 * @author taivt
 * @problem 441. Arranging Coins
 * @link https://leetcode.com/problems/arranging-coins/
 * @submission https://leetcode.com/problems/arranging-coins/submissions/968974193/
 * @difficulty Easy
 * @tags Math, Binary Search
 * @since 2023/06/11 22:43:31
 */
public class LC441_ArrangingCoins {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.arrangeCoins(5));
    System.out.println(solution.arrangeCoins(8));
    System.out.println(solution.arrangeCoins(1804289383));
  }

  /*
   * Space complexity: O(1)
   * Time complexity: O(log(sqrt(2n)))
   */
  private static class Solution {
    public int arrangeCoins(int n) {
      /*
      let x is the maximum of complete rows we can build by n coins
      x * (x + 1) / 2 <= n
      x^2 + x <= 2n
      x^2 + x + 1/4 <= 2n + 1/4
      (x + 1/2)^2 <= 2n + 1/4
      x + 1/2 <= sqrt(2n + 1/4)
      x <= sqrt(2n + 1/4) - 1/2
      x <= sqrt(2n) + 1
       */
      int low = 1;
      int high = (int) Math.sqrt(2L * n) + 1;

      int ans = 0;
      while (low <= high) {
        int mid = low + (high - low) / 2;
        long requiredCoins = calcRequiredCoins(mid);
        if (requiredCoins <= n) {
          ans = mid;
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }

      return ans;
    }

    private long calcRequiredCoins(int nOfRow) {
      return (long) nOfRow * (nOfRow + 1) / 2;
    }
  }
}

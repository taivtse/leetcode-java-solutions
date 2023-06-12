package binary_search;

/**
 * @author taivt
 * @problem 1482. Minimum Number of Days to Make m Bouquets
 * @link https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 * @submission https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/submissions/969661596/
 * @difficulty Medium
 * @tags Array, Binary Search
 * @since 2023/06/12 21:20:59
 */
public class LC1482_MinimumNumberOfDaysToMakeMBouquets {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
    System.out.println(solution.minDays(new int[]{1, 10, 3, 10, 2}, 3, 2));
    System.out.println(solution.minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
  }

  /*
   * Space complexity: O(1)
   * Time complexity: O(nlog(x)) where x is the maximum day
   */
  private static class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
      int maxDay = -1;
      for (int day : bloomDay) {
        if (day > maxDay) {
          maxDay = day;
        }
      }

      int start = 1;
      int end = maxDay;
      int ans = -1;
      while (start <= end) {
        int mid = start + (end - start) / 2;
        int nOfBouquets = calcBouquets(bloomDay, k, mid);
        if (nOfBouquets >= m) {
          ans = mid;
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      }

      return ans;
    }

    private int calcBouquets(int[] bloomDay, int k, int currentDay) {
      int nOfBouquets = 0;
      int adjFlowers = 0;
      for (int day : bloomDay) {
        if (day <= currentDay) {
          adjFlowers++;
          nOfBouquets += adjFlowers / k;
          adjFlowers = adjFlowers % k;
        } else {
          adjFlowers = 0;
        }
      }
      return nOfBouquets;
    }
  }
}

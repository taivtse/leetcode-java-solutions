package array.two_pointers;

import java.util.Arrays;

/**
 * @author taivt
 * @problem 1089. Duplicate Zeros
 * @link https://leetcode.com/problems/duplicate-zeros/
 * @submission https://leetcode.com/problems/duplicate-zeros/submissions/943761476/
 * @difficulty Easy
 * @tags Array, Two Pointers
 * @since 2023/04/23 16:28:35
 */
public class LC1089_DuplicateZeros {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] arr1 = {8, 4, 5, 0, 0, 0, 0, 7};
    solution.duplicateZeros(arr1);
    System.out.println(Arrays.toString(arr1));

    int[] arr2 = {1, 2, 3};
    solution.duplicateZeros(arr2);
    System.out.println(Arrays.toString(arr2));
  }

  /*
   * Space complexity: O(1)
   * Time complexity: O(n)
   */
  private static class Solution {

    public void duplicateZeros(int[] arr) {
      int nOfZeros = 0;
      int length = arr.length;
      int lastIdx = length - 1;
      for (int i = 0; i < length - nOfZeros; i++) {
        if (arr[i] != 0) {
          continue;
        }

        nOfZeros++;
        // Check remaining spaces, if no more spaces for the current zero -> don't duplicate it
        if (length - i - 1 < nOfZeros) {
          arr[lastIdx] = 0;
          nOfZeros--; // don't need to duplicate the current zero
          lastIdx--;
          break;
        }
      }

      if (nOfZeros == 0) {
        return;
      }

      for (int i = lastIdx; i >= nOfZeros; i--) {
        int shiftedEle = arr[i - nOfZeros];
        arr[lastIdx] = shiftedEle;
        lastIdx--;
        if (shiftedEle == 0) {
          arr[lastIdx] = 0;
          lastIdx--;
        }
      }
    }
  }
}

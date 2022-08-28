package bit_manipulation;

/**
 * @author taivt
 * @link https://leetcode.com/problems/single-number/
 * @since 2022/03/13 23:16:24
 */
public class LC136_SingleNumber {
  public static void main(String[] args) {
    int[] nums = new int[]{4, 1, 2, 1, 2};
    int singleNum = new Solution().singleNumber(nums);
    System.out.println(singleNum);
  }

  // Space Complexity: O(1)
  // Time Complexity: O(n)
  private static class Solution {
    public int singleNumber(int[] nums) {
      int singleNum = 0;
      for (int num : nums) {
        singleNum ^= num;
      }
      return singleNum;
    }
  }
}

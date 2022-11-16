package string;

/**
 * @author taivt
 * @link https://leetcode.com/problems/sum-of-digits-of-string-after-convert/
 * @since 2022/11/16 21:20:23
 */
public class LC1945_SumOfDigitsOfStringAfterConvert {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.getLucky("zbax", 2));
    System.out.println(solution.getLucky("iiii", 2));
    System.out.println(solution.getLucky("leetcode", 2));
  }

  // n: string length, times
  // Space Complexity: O(1)
  // Time Complexity: O(nk)
  private static class Solution {
    public int getLucky(String s, int k) {
      StringBuilder transStr = new StringBuilder();
      for (char c : s.toCharArray()) {
        int digit = c - 'a' + 1;
        transStr.append(digit);
      }

      String result = transStr.toString();
      for (int i = 0; i < k; i++) {
        result = sumOfDigits(result);
      }
      return Integer.parseInt(result);
    }

    private String sumOfDigits(String transStr) {
      int sum = 0;
      for (char digit : transStr.toCharArray()) {
        sum += digit - '0';
      }
      return String.valueOf(sum);
    }
  }
}

package string;

/**
 * @author taivt
 * @problem 1704. Determine if String Halves Are Alike
 * @link https://leetcode.com/problems/determine-if-string-halves-are-alike/
 * @submission https://leetcode.com/problems/determine-if-string-halves-are-alike/submissions/913142208/
 * @difficulty easy
 * @tags String Counting
 * @since 2023/03/11 16:16:07
 */
public class LC704_DetermineIfStringHalvesAreAlike {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.halvesAreAlike("book"));
    System.out.println(solution.halvesAreAlike("textbook"));
    System.out.println(solution.halvesAreAlike("hahaaa"));
  }

  /*
   * Space complexity: O(1)
   * Time complexity: O(n)
   */
  private static class Solution {
    public boolean halvesAreAlike(String s) {
      int halfLength = s.length() / 2;
      int balanceCount = 0;
      for (int i = 0; i < halfLength; i++) {
        if (isVowel(s.charAt(i))) {
          balanceCount++;
        }
        if (isVowel(s.charAt(halfLength + i))) {
          balanceCount--;
        }
      }

      return balanceCount == 0;
    }

    private boolean isVowel(char ch) {
      return ch == 'a' || ch == 'A'
          || ch == 'e' || ch == 'E'
          || ch == 'i' || ch == 'I'
          || ch == 'o' || ch == 'O'
          || ch == 'u' || ch == 'U';
    }
  }

}

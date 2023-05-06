package string;

/**
 * @author taivt
 * @problem 824. Goat Latin
 * @link https://leetcode.com/problems/goat-latin/
 * @submission https://leetcode.com/problems/goat-latin/submissions/945418417/
 * @difficulty Easy
 * @tags String
 * @since 2023/05/06 16:47:32
 */
public class LC824_GoatLatin {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.toGoatLatin("I speak Goat Latin"));
    System.out.println(solution.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    System.out.println(solution.toGoatLatin("Each word consists of lowercase and uppercase letters only"));
  }

  /*
   * Space complexity: O(n)
   * Time complexity: O(n)
   */
  private static class Solution {
    public String toGoatLatin(String sentence) {
      String[] words = sentence.split(" ");
      StringBuilder sb = new StringBuilder(sentence.length() * 2);
      for (int i = 0; i < words.length; i++) {
        String word = words[i];
        char firstLetter = word.charAt(0);
        char lcFirstLetter = Character.toLowerCase(firstLetter);
        if (lcFirstLetter == 'a' || lcFirstLetter == 'e' || lcFirstLetter == 'i' || lcFirstLetter == 'o' || lcFirstLetter == 'u') {
          sb.append(word);
        } else {
          sb.append(word.substring(1)).append(firstLetter);
        }

        sb.append("ma").append("a".repeat(i + 1));
        if (i < words.length - 1) {
          sb.append(" ");
        }
      }
      return sb.toString();
    }
  }
}

package string;

/**
 * @author taivt
 * @link https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 * @since 2022/06/29 20:37:44
 */
public class LC1832_CheckIfTheSentenceIsPangram {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(solution.checkIfPangram("leetcode"));
    }

    // Space Complexity: O(1)
    // Time Complexity: O(n)
    private static class Solution {
        public boolean checkIfPangram(String sentence) {
            boolean[] ascii = new boolean[26];
            int remaining = 26;
            for (int j = 0; j < sentence.length(); j++) {
                int pos = sentence.charAt(j) - 'a';
                if (!ascii[pos]) {
                    remaining--;
                    ascii[pos] = true;
                }
            }
            return remaining == 0;
        }
    }
}

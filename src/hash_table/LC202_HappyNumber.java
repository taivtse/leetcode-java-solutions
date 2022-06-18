package hash_table;

import java.util.HashSet;
import java.util.Set;

/**
 * @author taivt
 * @link https://leetcode.com/problems/happy-number/
 * @since 2022/03/15 19:02:22
 */
public class LC202_HappyNumber {
    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(19));
        System.out.println(new Solution().isHappy(2));
        System.out.println(new Solution().isHappy(1));
        System.out.println(new Solution().isHappy(1111111));
        System.out.println(new Solution().isHappy(44));
    }

    // Space Complexity: O(log(n))
    // Time Complexity: O(log(n))
    private static class Solution {
        public boolean isHappy(int n) {
            Set<Integer> set = new HashSet<>();
            do {
                n = sumSquareDigits(n);
                if (set.contains(n)) {
                    return false;
                }
                set.add(n);
            } while (n != 1);

            return true;
        }

        private int sumSquareDigits(int n) {
            int sum = 0;
            while (n > 0) {
                int lastDigit = n % 10;
                sum += lastDigit * lastDigit;   // sum = sum + lastDigit ^ 2
                n /= 10;
            }
            return sum;
        }
    }
}

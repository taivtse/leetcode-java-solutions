package math;

import java.util.Arrays;

/**
 * @author taivt
 * @link https://leetcode.com/problems/fibonacci-number/
 * @since 2022/06/05 21:30:55
 */
public class LC509_FibonacciNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(2));
        System.out.println(solution.fib(3));
        System.out.println(solution.fib(4));
    }

    private static class Solution {
        int[] f = new int[100];

        public int fib(int n) {
            Arrays.fill(f, -1);
            return fibRecursive(n);
        }

        private int fibIterative(int n) {
            f[0] = 0;
            f[1] = 1;
            for (int i = 2; i <= n; i++) {
                f[i] = f[i - 1] + f[i - 2];
            }
            return f[n];
        }

        private int fibRecursive(int n) {
            if (n == 0 || n == 1) {
                return n;
            }
            if (f[n] != -1) {
                return f[n];
            }

            int fn = fibRecursive(n - 1) + fibRecursive(n - 2);
            f[n] = fn;
            return fn;
        }
    }
}

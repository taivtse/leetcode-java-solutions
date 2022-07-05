package array.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taivt
 * @link https://leetcode.com/problems/binary-subarrays-with-sum/
 * @since 2022/06/27 22:36:01
 */
public class LC930_BinarySubarraysWithSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println(solution.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
    }

    // Space Complexity: O(1)
    // Time Complexity: O(n)
    private static class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(goal, 1);

            int sumSoFar = 0;
            int count = 0;
            for (int num : nums) {
                sumSoFar = sumSoFar + num;
                Integer freq = map.getOrDefault(sumSoFar, 0);
                count = count + freq;
                map.put(sumSoFar + goal, map.getOrDefault(sumSoFar + goal, 0) + 1);
            }

            return count;
        }
    }
}

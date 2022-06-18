package array.two_pointers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taivt
 * @since 2022/04/21 21:47:24
 */
public class LC1512_NumberOfGoodPairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
        System.out.println(solution.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3, 1}));
        System.out.println(solution.numIdenticalPairs(new int[]{1, 1, 1, 1}));
        System.out.println(solution.numIdenticalPairs(new int[]{1, 2, 3}));
    }

    private static class Solution {
        public int numIdenticalPairs(int[] nums) {
            int count = 0;
            Map<Integer, Integer> freq = new HashMap<>();

            for (int num : nums) {
                if (freq.containsKey(num)) {
                    Integer curFreq = freq.get(num);
                    count += curFreq;
                    freq.put(num, curFreq + 1);
                } else {
                    freq.put(num, 1);
                }
            }

            return count;
        }
    }
}

package heap;

import java.util.*;

/**
 * @author taivt
 * @problem 1488. Avoid Flood in The City
 * @link https://leetcode.com/problems/avoid-flood-in-the-city/
 * @submission https://leetcode.com/problems/avoid-flood-in-the-city/submissions/913193160/
 * @difficulty Medium
 * @tags Array, Hash Table, Binary Search, Greedy, Heap (Priority Queue)
 * @since 2023/03/11 17:17:11
 */
public class LC1488_Avoid_Flood_In_The_City {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.avoidFlood(new int[]{1, 2, 3, 4})));
    System.out.println(Arrays.toString(solution.avoidFlood(new int[]{1, 2, 0, 0, 2, 1})));
    System.out.println(Arrays.toString(solution.avoidFlood(new int[]{1, 2, 0, 1, 2})));
    System.out.println(Arrays.toString(solution.avoidFlood(new int[]{1, 2, 0, 0, 0, 0, 2, 1})));
  }

  /*
   * Space complexity:
   * Time complexity:
   */
  private static class Solution {
    public int[] avoidFlood(int[] rains) {
      // <full lake, next rain days to make the lake to be flood>
      Map<Integer, Deque<Integer>> nextRainDaysMap = new HashMap<>();
      for (int i = 0; i < rains.length; i++) {
        int lake = rains[i];
        if (lake == 0) {
          continue;
        }

        if (nextRainDaysMap.containsKey(lake)) {
          nextRainDaysMap.get(lake).addLast(i);
        } else {
          nextRainDaysMap.put(lake, new LinkedList<>());
        }
      }

      Comparator<int[]> ascComparator = Comparator.comparing(pair -> pair[0]);
      // int[]: int[0] is the rain day, int[1] is the lake will be rains over
      PriorityQueue<int[]> minHeap = new PriorityQueue<>(ascComparator);

      int[] results = new int[rains.length];
      for (int i = 0; i < rains.length; i++) {
        int lake = rains[i];
        if (lake == 0) {
          // dry a lake
          int[] top = minHeap.poll();
          if (top == null) {
            results[i] = 1; // Don't need to dry any lakes, this value doesn't matter
            continue;
          }
          int lakeToBeDry = top[1];
          results[i] = lakeToBeDry;
        } else {
          // check flood
          int[] top = minHeap.peek();
          if (top != null && top[1] == lake) {
            return new int[0];
          }

          // add to minHeap
          Deque<Integer> nextRainDays = nextRainDaysMap.get(lake);
          Integer nextRainDay = nextRainDays.pollFirst();
          if (nextRainDay != null) {
            minHeap.add(new int[]{nextRainDay, lake});
          }

          results[i] = -1;
        }
      }

      return results;
    }
  }
}

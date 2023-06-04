package linked_list;

import utils.ListNode;

import static utils.LinkedListUtil.buildCycleLinkedList;

/**
 * @author taivt
 * @link https://leetcode.com/problems/linked-list-cycle/
 * @since 2022/03/15 00:55:40
 */
public class LC141_LinkedListCycle {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.hasCycle(buildCycleLinkedList(3, 2, 0, -4)));
  }

  // Space Complexity: O(1)
  // Time Complexity: O(n)
  private static class Solution {
    public boolean hasCycle(ListNode head) {
      ListNode singleStep = head;
      ListNode doubleStep = head;

      while (doubleStep != null && doubleStep.next != null) {
        singleStep = singleStep.next;
        doubleStep = doubleStep.next.next;
        if (doubleStep == singleStep) {
          return true;
        }
      }

      return false;
    }
  }

}

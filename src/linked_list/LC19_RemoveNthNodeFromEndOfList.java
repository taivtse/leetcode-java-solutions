package linked_list;

import utils.ListNode;

import static utils.LinkedListUtil.buildLinkedList;

/**
 * @author taivt
 * @problem 19. Remove Nth Node From End of List
 * @link https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * @submission https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/963676329/
 * @difficulty Medium
 * @tags Linked List, Two Pointers
 * @since 2023/06/04 18:37:55
 */
public class LC19_RemoveNthNodeFromEndOfList {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.removeNthFromEnd(buildLinkedList(1, 2, 3, 4, 5), 1));
    System.out.println(solution.removeNthFromEnd(buildLinkedList(1), 1));
    System.out.println(solution.removeNthFromEnd(buildLinkedList(1, 2), 1));
  }

  /*
   * Space complexity: O(1)
   * Time complexity: O(n)
   */
  private static class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode itr = head;
      for (int i = 0; i < n; i++) {
        itr = itr.next;
      }

      if (itr == null) {
        return head.next;
      }

      ListNode precede = head;
      while (itr.next != null) {
        itr = itr.next;
        precede = precede.next;
      }

      precede.next = precede.next.next;
      return head;
    }
  }
}

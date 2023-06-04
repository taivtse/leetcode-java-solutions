package linked_list;

import utils.ListNode;

import static utils.LinkedListUtil.buildLinkedList;

/**
 * @author taivt
 * @link https://leetcode.com/problems/reverse-linked-list/
 * @since 2022/03/17 22:23:33
 */
public class LC206_ReverseLinkedList {

  public static void main(String[] args) {
    Solution solution = new Solution();
    ListNode head = solution.recursiveReverseList(buildLinkedList(1, 2, 3, 4, 5));
    System.out.println(head);
  }

  // Space Complexity: O(1)
  // Time Complexity: O(n)
  private static class Solution {
    public ListNode reverseList(ListNode head) {
      ListNode prev = null;
      while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
      }
      return prev;
    }

    public ListNode recursiveReverseList(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }

      ListNode newHead = recursiveReverseList(head.next);
      head.next.next = head;
      head.next = null;

      return newHead;
    }
  }

}

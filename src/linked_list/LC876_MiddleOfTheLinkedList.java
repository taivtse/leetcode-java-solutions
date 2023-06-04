package linked_list;

import utils.ListNode;

import static utils.LinkedListUtil.buildLinkedList;

/**
 * @author taivt
 * @link https://leetcode.com/problems/middle-of-the-linked-list/
 * @since 2022/03/15 00:35:05
 */
public class LC876_MiddleOfTheLinkedList {

  public static void main(String[] args) {
    ListNode head = buildLinkedList(1, 2, 3, 4, 5, 6);
    System.out.printf("The given linked list: %s%n", head);

    Solution solution = new Solution();
    ListNode middleNode = solution.middleNode(head);
    System.out.println("The middle node of the given linked list is: " + middleNode.val);
  }

  // Space Complexity: O(1)
  // Time Complexity: O(n)
  private static class Solution {
    public ListNode middleNode(ListNode head) {
      ListNode singleStep = head;
      ListNode doubleStep = head;

      while (doubleStep != null && doubleStep.next != null) {
        singleStep = singleStep.next;
        doubleStep = doubleStep.next.next;
      }

      return singleStep;
    }
  }

}

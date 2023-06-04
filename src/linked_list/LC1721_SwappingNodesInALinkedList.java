package linked_list;

import utils.ListNode;

import static utils.LinkedListUtil.buildLinkedList;

/**
 * @author taivt
 * @problem 1721. Swapping Nodes in a Linked List
 * @link https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 * @submission https://leetcode.com/problems/swapping-nodes-in-a-linked-list/submissions/963676862/
 * @difficulty Medium
 * @tags Linked List, Two Pointers
 * @since 2023/06/04 17:36:34
 */
public class LC1721_SwappingNodesInALinkedList {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.swapNodes(buildLinkedList(1, 2, 3, 4, 5), 2));
    System.out.println(solution.swapNodes(buildLinkedList(7, 9, 6, 6, 7, 8, 3, 0, 9, 5), 5));
    System.out.println(solution.swapNodes(buildLinkedList(1, 2, 3), 2));
  }

  /*
   * Space complexity: O(1)
   * Time complexity: O(n)
   */
  private static class Solution {
    public ListNode swapNodes(ListNode head, int k) {
      ListNode itr = head;
      for (int i = 1; i < k; i++) {
        itr = itr.next;
      }

      ListNode first = itr;
      ListNode second = head;
      while (itr.next != null) {
        itr = itr.next;
        second = second.next;
      }

      // Swap
      int temp = first.val;
      first.val = second.val;
      second.val = temp;

      return head;
    }
  }
}

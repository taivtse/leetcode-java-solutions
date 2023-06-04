package linked_list;

import utils.ListNode;

import static utils.LinkedListUtil.buildLinkedList;

/**
 * @author taivt
 * @link https://leetcode.com/problems/sort-list/
 * @since 2022/03/21 22:42:33
 */
public class LC148_SortList {
  public static void main(String[] args) {
    ListNode head = new Solution().sortList(buildLinkedList(3, 2, 4, 4, 0));
    System.out.println("After sorted: ");
    Solution.print(head);
  }

  // Space Complexity: O(1)
  // Time Complexity: O(nlog(n))
  private static class Solution {
    static void print(ListNode head) {
      ListNode iterator = head;
      while (iterator != null) {
        System.out.printf("%d ", iterator.val);
        iterator = iterator.next;
      }
      System.out.println();
    }

    public ListNode sortList(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }

      ListNode mid = findMid(head);
      ListNode nextMid = mid.next;
      mid.next = null;

      System.out.println("=================================");
      System.out.println("left: " + head.val);
      System.out.println("mid: " + mid.val);
      System.out.println("right: " + nextMid.val);
      System.out.println("=================================");
      System.out.println("Left part before merge: ");
      print(head);
      System.out.println("Right part before merge: ");
      print(nextMid);

      ListNode left = sortList(head);
      ListNode right = sortList(nextMid);

      ListNode newHead = merge(left, right);
      System.out.println("New merged linked list: ");
      print(newHead);
      return newHead;
    }

    private ListNode merge(ListNode left, ListNode right) {
      ListNode head = left.val <= right.val ? left : right;
      while (left != null && right != null) {
        if (left.val <= right.val) {
          if (left.next != null && left.next.val <= right.val) {
            left = left.next;
            continue;
          }
          ListNode nextLeft = left.next;
          left.next = right;
          left = nextLeft;
        } else {
          if (right.next != null && right.next.val < left.val) {
            right = right.next;
            continue;
          }
          ListNode nextRight = right.next;
          right.next = left;
          right = nextRight;
        }
      }
      return head;
    }

    private ListNode findMid(ListNode head) {
      ListNode slow = head;
      ListNode fast = head.next;
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }
      return slow;
    }
  }
}

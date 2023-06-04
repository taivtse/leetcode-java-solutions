package utils;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author taivt
 * @since 2023/06/04 17:39:56
 */
public class LinkedListUtil {
  public static ListNode buildLinkedList(Integer... nodes) {
    return build(false, nodes);
  }

  public static ListNode buildCycleLinkedList(Integer... nodes) {
    return build(true, nodes);
  }

  private static ListNode build(boolean isCycle, Integer... nodes) {
    Iterator<Integer> iterator = Arrays.stream(nodes).iterator();
    ListNode head = new ListNode(iterator.next());
    ListNode cur = head;
    while (iterator.hasNext()) {
      ListNode next = new ListNode(iterator.next());
      cur.next = next;
      cur = next;
    }
    if (isCycle) {
      cur.next = head;
    }
    return head;
  }
}

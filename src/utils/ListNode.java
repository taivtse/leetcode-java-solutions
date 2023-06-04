package utils;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public String toString() {
    List<Integer> values = new ArrayList<>();
    ListNode cur = this;
    while (cur != null) {
      values.add(cur.val);
      cur = cur.next;
    }
    return values.toString();
  }
}
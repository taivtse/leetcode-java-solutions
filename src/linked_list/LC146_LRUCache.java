package linked_list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taivt
 * @link https://leetcode.com/problems/lru-cache/
 * @since 2022/06/18 17:48:56
 */
public class LC146_LRUCache {
  public static void main(String[] args) {
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    System.out.println(lRUCache.get(1)); // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    System.out.println(lRUCache.get(2)); // returns -1 (not found)
    lRUCache.put(1, 7); // cache is {3=3, 1=7}
    lRUCache.put(4, 4); // LRU key was 3, evicts key 3, cache is {1=7, 4=4}
    System.out.println(lRUCache.get(1)); // return 7
    System.out.println(lRUCache.get(3)); // return -1  (not found)
    System.out.println(lRUCache.get(4)); // return 4
  }

  private static class LRUCache {

    private final int capacity;
    private final DoublyLinkedList linkedList = new DoublyLinkedList();
    private final Map<Integer, Node> map = new HashMap<>();
    public LRUCache(int capacity) {
      this.capacity = capacity;
    }

    public int get(int key) {
      if (!map.containsKey(key)) {
        return -1;
      }
      Node node = map.get(key);
      linkedList.remove(node);
      Node head = linkedList.addFirst(key, node.value);
      map.put(key, head);
      return node.value;
    }

    public void put(int key, int value) {
      if (map.containsKey(key)) {
        Node node = map.get(key);
        linkedList.remove(node);
        Node head = linkedList.addFirst(key, value);
        map.put(key, head);
      } else {
        if (map.size() == capacity) {
          Node removed = linkedList.removeLast();
          if (removed != null) {
            map.remove(removed.key);
          }
        }
        Node head = linkedList.addFirst(key, value);
        map.put(key, head);
      }
    }

    private static class Node {
      int key;
      int value;
      Node prev;
      Node next;

      public Node(int key, int value) {
        this.key = key;
        this.value = value;
      }
    }

    private static class DoublyLinkedList {
      Node head;
      Node tail;

      public Node addFirst(int key, int value) {
        Node node = new Node(key, value);
        if (head == null) {
          head = node;
          tail = node;
        } else {
          node.next = head;
          head.prev = node;
          head = node;
        }
        return node;
      }

      public Node removeLast() {
        if (tail == null) {
          return null;
        }
        Node node = tail;
        if (tail.prev == null) {
          head = null;
          tail = null;
        } else {
          tail = tail.prev;
          tail.next = null;
        }
        return node;
      }

      public void remove(Node node) {
        if (node == head) {
          head = node.next;
        }
        if (node == tail) {
          tail = node.prev;
        }
        if (node.prev != null) {
          node.prev.next = node.next;
        }
        if (node.next != null) {
          node.next.prev = node.prev;
        }
      }

    }
  }
}

package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author taivt
 * @problem 2284. Sender With Largest Word Count
 * @link https://leetcode.com/problems/sender-with-largest-word-count/
 * @submission https://leetcode.com/problems/sender-with-largest-word-count/submissions/945469041/
 * @difficulty Medium
 * @tags Array, Hash Table, String, Counting
 * @since 2023/05/06 18:49:48
 */
public class LC2284_SenderWithLargestWordCount {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.largestWordCount(new String[]{"Hello userTwooo", "Hi userThree", "Wonderful day Alice", "Nice day userThree"}, new String[]{"Alice", "userTwo", "userThree", "Alice"}));
    System.out.println(solution.largestWordCount(new String[]{"How is leetcode for everyone", "Leetcode is useful for practice"}, new String[]{"Bob", "Charlie"}));
  }

  /*
   * Space complexity: O(n)
   * Time complexity: O(n)
   */
  private static class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
      Map<String, Counter> map = new HashMap<>();
      for (int i = 0; i < messages.length; i++) {
        String message = messages[i];
        String sender = senders[i];
        int wordCount = countWords(message);
        Counter counter = map.get(sender);
        if (counter == null) {
          counter = new Counter(sender, wordCount);
        } else {
          counter.count += wordCount;
        }
        map.put(sender, counter);
      }

      Iterator<Counter> iterator = map.values().iterator();
      Counter maxCounter = iterator.next();
      Counter nextCounter;
      while (iterator.hasNext()) {
        nextCounter = iterator.next();
        if (nextCounter.compareTo(maxCounter) > 0) {
          maxCounter = nextCounter;
        }
      }

      return maxCounter.sender;
    }

    private int countWords(String message) {
      int spaceCount = 0;
      for (int i = 0; i < message.length(); i++) {
        if (message.charAt(i) == ' ') {
          spaceCount++;
        }
      }
      return spaceCount + 1;
    }

    private static class Counter implements Comparable<Counter> {
      public String sender;
      public int count;

      public Counter(String sender, int count) {
        this.sender = sender;
        this.count = count;
      }

      @Override
      public int compareTo(Counter o) {
        if (count > o.count) {
          return 1;
        } else if (count < o.count) {
          return -1;
        } else {
          return sender.compareTo(o.sender);
        }
      }
    }
  }
}

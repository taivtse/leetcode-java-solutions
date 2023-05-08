package binary_tree.bst;

import utils.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

import static utils.TreeUtil.buildBinaryTree;

/**
 * @author taivt
 * @problem 230. Kth Smallest Element in a BST
 * @link https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * @submission https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/934737566/
 * @difficulty Medium
 * @tags Tree, Depth-First Search, Binary Search Tree, Binary Tree
 * @since 2023/04/16 20:24:48
 */
public class LC230_KthSmallestElementInABST {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.kthSmallest(buildBinaryTree(3, 1, 4, null, 2), 1));
    System.out.println(solution.kthSmallest(buildBinaryTree(5, 3, 6, 2, 4, null, null, 1), 3));
  }

  /*
   * Space complexity: O(1)
   * Time complexity: O(n)
   */
  private static class Solution {
    public int kthSmallest(TreeNode root, int k) {
      AtomicInteger kth = new AtomicInteger(k);
      return kthSmallestRecursive(root, kth);
    }

    private int kthSmallestRecursive(TreeNode root, AtomicInteger kth) {
      if (root == null) {
        return -1;
      }

      int foundValue = kthSmallestRecursive(root.left, kth);

      if (kth.get() == 1) {
        kth.set(-1);  // Found a value
        return root.val;
      }

      if (kth.get() == -1) {
        return foundValue;
      }

      kth.set(kth.get() - 1);
      return kthSmallestRecursive(root.right, kth);
    }
  }
}

package binary_tree.bst;

import utils.TreeNode;

import static utils.TreeUtil.buildBinaryTree;

/**
 * @author taivt
 * @problem 938. Range Sum of BST
 * @link https://leetcode.com/problems/range-sum-of-bst/
 * @submission https://leetcode.com/problems/range-sum-of-bst/submissions/934638177/
 * @difficulty Easy
 * @tags Tree, Depth-First Search, Binary Search Tree, Binary Tree
 * @since 2023/04/16 16:14:12
 */
public class LC938_RangeSumOfBST {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.rangeSumBST(buildBinaryTree(10, 5, 15, 3, 7, null, 18), 7, 15));
    System.out.println(solution.rangeSumBST(buildBinaryTree(10, 5, 15, 3, 7, 13, 18, 1, null, 6), 6, 10));
  }

  /*
   * Space complexity: O(1)
   * Time complexity: O(n)
   */
  private static class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
      if (root == null) {
        return 0;
      }
      if (root.val < low) {
        return rangeSumBST(root.right, low, high);
      } else if (root.val > high) {
        return rangeSumBST(root.left, low, high);
      }

      int leftSum = rangeSumBST(root.left, low, high);
      int rightSum = rangeSumBST(root.right, low, high);
      return root.val + leftSum + rightSum;
    }
  }
}

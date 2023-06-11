package binary_tree;

import utils.TreeNode;

import static utils.TreeUtil.buildBinaryTree;

/**
 * @author taivt
 * @link https://leetcode.com/problems/invert-binary-tree/
 * @since 2022/04/27 21:38:00
 */
public class LC226_InvertBinaryTree {
  public static void main(String[] args) {
    Solution solution = new Solution();
    TreeNode newTree1 = solution.invertTree(buildBinaryTree(4, 2, 7, 1, 3, 6, 9));
    System.out.println(newTree1);
    TreeNode newTree2 = solution.invertTree(buildBinaryTree(2, 1, 3));
    System.out.println(newTree2);
    TreeNode newTree3 = solution.invertTree(buildBinaryTree());
    System.out.println(newTree3);
  }

  // Space Complexity: O(n)
  // Time Complexity: O(n)
  private static class Solution {
    public TreeNode invertTree(TreeNode root) {
      if (root == null) {
        return null;
      }

      TreeNode right = root.right;
      TreeNode left = root.left;
      root.left = invertTree(right);
      root.right = invertTree(left);
      return root;
    }
  }
}

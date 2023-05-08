package binary_tree;

import utils.TreeNode;
import utils.TreeUtil;

/**
 * @author taivt
 * @problem 106. Construct Binary Tree from Inorder and Postorder Traversal
 * @link https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @submission // TODO
 * @difficulty
 * @tags
 * @since 2023/05/08 20:23:18
 */
public class LC106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(TreeUtil.toArray(solution.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3})));
  }

  /*
   * Space complexity: // TODO
   * Time complexity: // TODO
   */
  private static class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

    }
  }
}

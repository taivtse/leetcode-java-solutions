package utils;

import static utils.TreeUtil.toArray;

/**
 * @author taivt
 * @since 2022/04/14 00:28:30
 */
public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {
  }

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  @Override
  public String toString() {
    return toArray(this).toString();
  }
}

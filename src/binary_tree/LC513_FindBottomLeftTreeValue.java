package binary_tree;

import utils.TreeNode;

import static utils.TreeBuilder.buildBinaryTree;

/**
 * @author taivt
 * @link https://leetcode.com/problems/find-bottom-left-tree-value/
 * @since 2022/04/14 23:49:01
 */
public class LC513_FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findBottomLeftValue(buildBinaryTree(2, 1, 3)));
        System.out.println(solution.findBottomLeftValue(buildBinaryTree(1, 2, 3, 4, null, 5, 6, null, null, 7)));
    }

    // n: nodes
    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution {
        private int leftmost;
        private int curLevel;

        public int findBottomLeftValue(TreeNode root) {
            leftmost = root.val;
            curLevel = 0;
            find(root, curLevel);
            return leftmost;
        }

        private void find(TreeNode node, int level) {
            if (node == null) {
                return;
            }

            if (level > curLevel) {
                leftmost = node.val;
                curLevel = level;
            }

            find(node.left, level + 1);
            find(node.right, level + 1);
        }
    }
}

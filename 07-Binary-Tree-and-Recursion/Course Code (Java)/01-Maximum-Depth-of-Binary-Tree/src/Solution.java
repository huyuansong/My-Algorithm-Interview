// 104. Maximum Depth of Binary Tree
// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
// 时间复杂度: O(n), n是树中的节点个数
// 空间复杂度: O(h), h是树的高度
class Solution {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 需要深刻理解递归：
     * 二叉树的左右子树都是一颗新的二叉树，这样就没有结束条件了，因此 null 也是一颗二叉树
     * null 二叉树是递归结束的地方
     * @param root 要求解的二叉树的根节点
     * @return 返回二叉树的高度
     */
    public int maxDepth(TreeNode root) {

        /** null 对于用户来说不算一层，因此返回 0
         *  但是对于程序员来说，null 应该算是二叉树的一部分，是递归结束的地方
         */
        if(root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

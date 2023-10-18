/// 235. Lowest Common Ancestor of a Binary Search Tree
/// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
/// 时间复杂度: O(lgn), 其中n为树的节点个数
/// 空间复杂度: O(h), 其中h为树的高度
class Solution {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 求最近公共祖先
     * @param root 要查找的二叉树的根节点
     * @param p 要查找的其中一个节点
     * @param q 要查找的另外一个节点
     * @return p,q 的最近祖先节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p == null || q == null)
            throw new IllegalArgumentException("p or q can not be null.");

        if(root == null)
            return null;

        if(p.val < root.val && q.val < root.val) // p,q 都在左子树
            return lowestCommonAncestor(root.left, p, q);
        if(p.val > root.val && q.val > root.val) // p,q 都在右子树
            return lowestCommonAncestor(root.right, p, q);

        // 要么就是 p 是根节点 或者 q 是根节点 或者 p,q 分散在左右两颗子树中
        // 这时 p,q 的最近公共祖先就是 root 本身，直接返回 root 即可
        assert p.val == root.val || q.val == root.val
                || (root.val - p.val) * (root.val - q.val) < 0;
        return root;

    }
}

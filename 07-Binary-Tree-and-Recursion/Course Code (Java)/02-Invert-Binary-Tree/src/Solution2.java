
/** 226. Invert Binary Tree
 https://leetcode.com/problems/invert-binary-tree/description/
 *
 * 前面翻转链表，这里要翻转二叉树，其实本质都是一样的，可以利用递归的方式来写
 * diff：这里是对称翻转
 */
/// 时间复杂度: O(n), n为树中节点个数
/// 空间复杂度: O(h), h为树的高度
public class Solution2 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 根据给定的二叉树的根节点反转二叉树，得到反转后的二叉树根节点
     * @param root 以 root 为根节点的二叉树
     * @return 反转后的二叉树的根节点，其实还是传入时的 root
     */
    public TreeNode invertTree(TreeNode root) {

        if(root == null)
            return null;

        // 自顶向下 ，这样写代码不够好，因为本题中的递归函数是有返回值的，这里没有用上
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    /** C++的代码可以写的更加简洁，因为C++自己提供了一个交换函数，可以交换指针
     * TreeNode* invertTree(TreeNode* root) {
     *
     *         if(root == NULL)
     *             return NULL;
     *
     *         invertTree(root->left);
     *         invertTree(root->right);
     *
     *         swap(root->left, root->right);
     *
     *         return root;
     *     }
     */

}

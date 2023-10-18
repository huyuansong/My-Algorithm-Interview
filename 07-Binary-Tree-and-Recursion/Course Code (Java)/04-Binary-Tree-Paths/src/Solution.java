import java.util.List;
import java.util.ArrayList;

/// 257. Binary Tree Paths
/// https://leetcode.com/problems/binary-tree-paths/description/
/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * A leaf is a node with no children.
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 */
/// 时间复杂度: O(n), n为树中的节点个数
/// 空间复杂度: O(h), h为树的高度
public class Solution {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {

        ArrayList<String> res = new ArrayList<String>();

        // 处理用户输入的临界情况
        if(root == null)
            return res;

        // 递归的结束条件 root 为叶子节点
        if(root.left == null && root.right == null){
            res.add(Integer.toString(root.val));
            return res;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        // root + 原来递归得到的数字路径
        for(String s: leftPaths){
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }

        List<String> rightPaths = binaryTreePaths(root.right);
        for(String s: rightPaths) {
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }

        return res;
    }
}

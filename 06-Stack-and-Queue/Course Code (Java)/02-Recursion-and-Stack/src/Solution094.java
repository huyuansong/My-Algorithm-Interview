import java.util.ArrayList;
import java.util.List;

/// 94. Binary Tree Inorder Traversal
/// https://leetcode.com/problems/binary-tree-inorder-traversal/solution/
/// 二叉树的中序遍历
/// 时间复杂度: O(n), n为树的节点个数
/// 空间复杂度: O(h), h为树的高度
public class Solution094 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode node, List<Integer> list){
        if(node != null){ // if 这里就是递归的结束条件 node == null 则返回
            inorderTraversal(node.left, list);
            list.add(node.val);
            inorderTraversal(node.right, list);
        }
    }
    /** 总结：
     *  使用系统栈时，可以直接按照代码的逻辑理解顺序
     * 如果显示的引入并使用栈stack时，需要注意栈的先写后调用的性质
     * */


}

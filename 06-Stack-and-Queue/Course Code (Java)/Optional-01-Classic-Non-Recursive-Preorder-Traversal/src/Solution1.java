/// Source : https://leetcode.com/problems/binary-tree-preorder-traversal/description/
/// Author : liuyubobobo
/// Time   : 2017-11-17

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Classic Non-Recursive algorithm for preorder traversal
// Time Complexity: O(n), n is the node number in the tree
// Space Complexity: O(h), h is the height of the tree
public class Solution1 {

    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);   // 先将根元素放入到栈中

        while(!stack.empty()){
            TreeNode curNode = stack.pop();
            res.add(curNode.val);          // 根 对于叶子节点，右左子树都为空，后续代码消失

            // 因为这里借用了显示的 Stack 使用，所以入栈的顺序是 右左；出栈的顺序是 左右
            if(curNode.right != null)
                stack.push(curNode.right);  // 右
            if(curNode.left != null)
                stack.push(curNode.left);    // 左
        }
        return res;
    }

}

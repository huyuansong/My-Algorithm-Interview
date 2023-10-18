import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/// 144. Binary Tree Preorder Traversal
/// https://leetcode.com/problems/binary-tree-preorder-traversal/description/
/// 非递归二叉树的前序遍历
/// 时间复杂度: O(n), n为树的节点个数
/// 空间复杂度: O(h), h为树的高度
public class Solution144 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private class Command{
        String s;   // go, print
        TreeNode node;
        Command(String s, TreeNode node){
            this.s = s;
            this.node = node;
        }
    };

    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        // 这不是递归结束，因为这里没有用到递归。这是处理用户输入的临界情况问题，null 树遍历返回 空
        if(root == null)
            return res;
        // 准备一个栈，模拟系统栈，先加入 根 元素
        Stack<Command> stack = new Stack<Command>();
        stack.push(new Command("go", root));

        while(!stack.empty()){
            // 先处理栈顶部元素
            Command command = stack.pop();

            // 栈顶部元素需要分情况处理
            // 如果是 print 直接累计结果，
            // 如果是 入栈 ，那么要先处理好 左右子树 的入栈；
            if(command.s.equals("print"))
                res.add(command.node.val);
            else{
                assert command.s.equals("go");
                if(command.node.right != null)
                    stack.push(new Command("go",command.node.right));
                if(command.node.left != null)
                    stack.push(new Command("go",command.node.left));

                stack.push(new Command("print", command.node));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //                  4
        //              /       \
        //              2        6
        //            /   \     /  \
        //           1     3    5   7
        //          / \    /\   /\  /\
        //        null null
        Solution144 solution144 = new Solution144();

        Solution144.TreeNode node1 = solution144.new TreeNode(1, null, null);
        Solution144.TreeNode node3 = solution144.new TreeNode(3, null, null);
        Solution144.TreeNode node5 = solution144.new TreeNode(5, null, null);
        Solution144.TreeNode node7 = solution144.new TreeNode(7, null, null);

        Solution144.TreeNode node2 = solution144.new TreeNode(2, node1, node3);
        Solution144.TreeNode node6 = solution144.new TreeNode(6, node5, node7);

        Solution144.TreeNode node4 = solution144.new TreeNode(4, node2, node6);


        List<Integer> list = solution144.preorderTraversal(node4);
        System.out.println(list);

    }

}

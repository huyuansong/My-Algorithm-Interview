import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/// 94. Binary Tree Inorder Traversal
/// https://leetcode.com/problems/binary-tree-inorder-traversal/solution/
/// 非递归二叉树的中序遍历
/// 时间复杂度: O(n), n为树的节点个数
/// 空间复杂度: O(h), h为树的高度
public class Solution094 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; };
        TreeNode(int x ,TreeNode left ,TreeNode right) { val = x; this.left = left ;this.right = right;}
    }

    private class Command{
        String s;   // go, print
        TreeNode node;
        Command(String s, TreeNode node){
            this.s = s;
            this.node = node;
        }
    };

    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        // 处理边界案例的情况，如果用户输入的是 null 树，那么遍历的结果为 空
        if(root == null) {
            return res;
        }

        // 解决问题的初始化
        Stack<Command> stack = new Stack<Command>();
        stack.push(new Command("go", root));

        while(!stack.empty()){

            // 将结果转移到要输出的动态数组中 ，这里是出栈的顺序
            // （一般会将结束的条件写在最前面，避免出现漏判）
            Command command = stack.pop();
            if(command.s.equals("print")) {
                res.add(command.node.val);
            }

            else{
                assert command.s.equals("go");
                if(command.node.right != null){
                    stack.push(new Command("go",command.node.right));
                }

                stack.push(new Command("print", command.node));

                if(command.node.left != null){
                    stack.push(new Command("go",command.node.left));
                }
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
        Solution094 solution094 = new Solution094();

        TreeNode node1 = solution094.new TreeNode(1, null, null);
        TreeNode node3 = solution094.new TreeNode(3, null, null);
        TreeNode node5 = solution094.new TreeNode(5, null, null);
        TreeNode node7 = solution094.new TreeNode(7, null, null);

        TreeNode node2 = solution094.new TreeNode(2, node1, node3);
        TreeNode node6 = solution094.new TreeNode(6, node5, node7);

        TreeNode node4 = solution094.new TreeNode(4, node2, node6);


        List<Integer> list = solution094.inorderTraversal(node4);
        System.out.println(list);

    }

}

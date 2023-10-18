import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/// 94. Binary Tree Inorder Traversal
/// https://leetcode.com/problems/binary-tree-inorder-traversal/solution/
/// 非递归二叉树的中序遍历
/// 时间复杂度: O(n), n为树的节点个数
/// 空间复杂度: O(h), h为树的高度
public class Solution094Back {

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
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        // 处理边界案例的情况，如果用户输入的是 null 树，那么遍历的结果为 空
        if(root == null) {
            return res;
        }

        // 解决一般性问题的初始化，整个程序中只执行1次，这里只是为了解决和while循环逻辑不统一问题
        Stack<Command> stack = new Stack<Command>();
        stack.push(new Command("go", root));
        System.out.println("将根节点go"+ root.val +"入栈");

        while(!stack.empty()){

            // 先取出栈顶元素，看能不能直接出栈，如果是 print 直接出栈，否则先处理孩子
            Command command = stack.pop();
            System.out.println("将" +command.s + command.node.val + "出栈");

            // 如果是print话，那么统计到结果中
            if(command.s.equals("print")) {
                System.out.println("和上方是同一个节点，将根节点print" + command.node.val + "出栈");
                res.add(command.node.val);
                System.out.println("res的值为：" + res );
            }
            // 将子树入栈
            else{
                assert command.s.equals("go");

                // 如果子树存在，先将右子树根节点入栈
                if(command.node.right != null){
                    stack.push(new Command("go",command.node.right));
                    System.out.println("将"+command.node.val+"最小二叉树中右子树go"+command.node.right.val+"入栈");
                }

                // 将自身打印入栈，并且是print 为什么？
                // 出栈的顺序为倒序，左根右，叶子节点左右子树为null，直接打印叶子节点
                stack.push(new Command("print", command.node));
                System.out.println("将最小二叉树中根节点print" + command.node.val + "入栈");

                // 如果左子树存在，将左子树入栈
                if(command.node.left != null){
                    stack.push(new Command("go",command.node.left));
                    System.out.println("将最小二叉树中左子树go" + command.node.left.val +"入栈");
                }
            }

        }
        System.out.println("res的值为" + res);
        System.out.println(stack.isEmpty()); // true
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
        Solution094Back solution094Back = new Solution094Back();

        TreeNode node1 = solution094Back.new TreeNode(1, null, null);
        TreeNode node3 = solution094Back.new TreeNode(3, null, null);
        TreeNode node5 = solution094Back.new TreeNode(5, null, null);
        TreeNode node7 = solution094Back.new TreeNode(7, null, null);

        TreeNode node2 = solution094Back.new TreeNode(2, node1, node3);
        TreeNode node6 = solution094Back.new TreeNode(6, node5, node7);

        TreeNode node4 = solution094Back.new TreeNode(4, node2, node6);


        List<Integer> list = solution094Back.inorderTraversal(node4);
        System.out.println(list);

    }

}

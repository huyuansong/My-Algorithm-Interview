import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import javafx.util.Pair;

/// 102. Binary Tree Level Order Traversal
/// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
/// 二叉树的层序遍历 需要借助队列（先进先出）这种性质的数据结构做辅助的存储
/// 时间复杂度: O(n), n为树的节点个数
/// 空间复杂度: O(n)
class Solution {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        // 准备一个动态的二维数组用来存储每一层的元素
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

        // 处理用户输入的边界情况。不是递归结束条件，这不是递归函数
        if(root == null)
            return res;

        // 我们使用LinkedList来做为我们的先入先出的队列
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<Pair<TreeNode, Integer>>();
        queue.addLast(new Pair<TreeNode, Integer>(root, 0));

        while(!queue.isEmpty()){

            Pair<TreeNode, Integer> front = queue.removeFirst();
            TreeNode node = front.getKey();
            int level = front.getValue();

            // level 从 0 开始，而 res 是一个二维数组，size 从 1 开始计算
            // 说明是tree新的一层了
            if(level == res.size())
                res.add(new ArrayList<Integer>()); // 为二维数组添加一个新元素（tree 新的一层）

            // 同一层的元素
            assert level < res.size();
            res.get(level).add(node.val);


            // 处理下一层节点的情况 , 将左右节点加入队列中
            if(node.left != null)
                queue.addLast(new Pair<TreeNode, Integer>(node.left, level + 1));
            if(node.right != null)
                queue.addLast(new Pair<TreeNode, Integer>(node.right, level + 1));
        }

        return res;
    }
}

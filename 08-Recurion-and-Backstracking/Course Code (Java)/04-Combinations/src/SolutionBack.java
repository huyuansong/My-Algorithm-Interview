import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/// 77. Combinations
/// https://leetcode.com/problems/combinations/description/

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 *
 * 分析：这是一个 组合问题
 */
/// 时间复杂度: O(n^k)
/// 空间复杂度: O(k)
public class SolutionBack {

    private ArrayList<List<Integer>> res;

    /**
     * 计算组合数
     * @param n 参与组合元素的范围 [1,n]
     * @param k 组合的数字位数
     * @return 由多个 组合数 构成的列表，每个元素是一个 组合数
     */
    public List<List<Integer>> combine(int n, int k) {

        res = new ArrayList<List<Integer>>();
        if(n <= 0 || k <= 0 || k > n)
            return res;

        LinkedList<Integer> c = new LinkedList<Integer>();
        generateCombinations(n, k, 1, c);

        return res;
    }

    // 求解C(n,k), 当前已经找到的组合存储在c中, 需要从start开始搜索新的元素
    // 我们要求的结果需要不断的拼接，用返回值处理不方便，所以返回值设置为void ,提升为类中的成员变量，简化结果的拼接过程
    private void generateCombinations(int n, int k, int start, LinkedList<Integer> c){

        if(c.size() == k){
            res.add((List<Integer>)c.clone());
            System.out.println("找到了一个合适的答案，递归函数提前退出，递归树向上走一层");
            return;
        }

        for(int i = start ; i <= n ; i ++){  // 123 i 逐渐在增大，能循环的数越来越少，其实就是一颗颗子树的过程
            c.addLast(i);  // 1
            System.out.println("进入新一轮循环" + "i：" + i +" 此时 c:" +  c );

            System.out.println("达不到要求条件，递归树向下再走一层");
            generateCombinations(n, k, i + 1, c); // 12

            c.removeLast(); // 将原先递归轮中加入的数字移除，供后续大递归再次使用
            System.out.println("递归结束将 i 元素移除 i：" + i +" "+ c );
        }

        System.out.println("这是一个 for 循环的结束");
        return;
    }

    private static void printList(List<Integer> list){
        for(Integer e: list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        List<List<Integer>> res = (new SolutionBack()).combine(4,  3);
        for(List<Integer> list: res)
            printList(list);
    }
}

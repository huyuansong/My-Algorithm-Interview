import java.util.LinkedList;
import javafx.util.Pair;

// 279. Perfect Squares
// https://leetcode.com/problems/perfect-squares/description/
/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * 解：构建一个图，对图进行广度优先遍历，遍历需要队列
 *
 */
// 该方法会导致 Time Limit Exceeded 或者 Memory Limit Exceeded
// 时间复杂度: O(2^n)
// 空间复杂度: O(2^n)
public class Solution1 {

    public int numSquares(int n) {
        // Pair( 第几个数字,已经产生的步数 )
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        queue.addLast(new Pair<Integer, Integer>(n, 0));

        // 虽然这里是图，但是和树的遍历方式是一样的
        // 不过还是有一点不一样，对于树而言，不会有重复访问的情况，但是图就会导致多次访问同一个元素
        // 所以这种写法会超时，优化，看下一个方案
        while(!queue.isEmpty()){
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();

            // 递推的结束条件
            if(num == 0)
                return step;

            // 递推公式
            for(int i = 1 ; num - i*i >= 0 ; i ++)
                queue.addLast(new Pair(num - i * i, step + 1));
        }

        throw new IllegalStateException("No Solution.");
    }

    public static void main(String[] args) {

        System.out.println((new Solution1()).numSquares(12));
        System.out.println((new Solution1()).numSquares(13));
    }
}

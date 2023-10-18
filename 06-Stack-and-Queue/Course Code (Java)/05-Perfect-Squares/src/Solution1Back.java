import javafx.util.Pair;

import java.util.LinkedList;

// 279. Perfect Squares
// https://leetcode.com/problems/perfect-squares/description/

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
// 该方法会导致 Time Limit Exceeded 或者 Memory Limit Exceeded
// 时间复杂度: O(2^n)
// 空间复杂度: O(2^n)
public class Solution1Back {

    public int numSquares(int n) {
        // Pair( 剩余的数,已经产生的步数 )
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        queue.addLast(new Pair<Integer, Integer>(n, 0)); // 在循环逻辑之前，先把根元素加入队列中

        while(!queue.isEmpty()){
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();
            System.out.printf("出栈的元素是 num=%d , step=%d \n" , num , step );

            // 递推的结束条件
            if(num == 0)
                return step;

            // 递推公式 对于每一个平方数，都进行了一轮到0 的广度遍历，因此有太多的重复元素进入到队列中统计其步数
            for(int i = 1 ; num - i*i >= 0 ; i ++) {
                int a = num - i*i;
                queue.addLast(new Pair(a, step + 1 ));
                System.out.printf("入栈的元素是 num=%d , step=%d \n" , a , step+1  );
            }
        }

        throw new IllegalStateException("No Solution.");
    }

    public static void main(String[] args) {

        System.out.println((new Solution1Back()).numSquares(12));
        //System.out.println((new Solution1Back()).numSquares(13));
    }
}

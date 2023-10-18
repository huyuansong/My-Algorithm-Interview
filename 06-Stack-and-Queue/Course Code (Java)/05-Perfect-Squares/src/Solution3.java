import java.util.LinkedList;
import javafx.util.Pair;

// 279. Perfect Squares
// https://leetcode.com/problems/perfect-squares/description/
// 思路没有变，在代码实现上的一些优化
// 时间复杂度: O(n)
// 空间复杂度: O(n)
public class Solution3 {

    public int numSquares(int n) {

        if(n == 0)
            return 0;

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        queue.addLast(new Pair<Integer, Integer>(n, 0));

        boolean[] visited = new boolean[n+1];
        visited[n] = true;

        while(!queue.isEmpty()){
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();

            if(num == 0)
                return step;

            for(int i = 1 ;  ; i ++){
                int a = num - i*i;
                if ( a < 0 ) {  // 循环继续的条件就是 a>=0
                    break;
                }
                if(a == 0) {  // 可以提前结束，没有必要将最后一个元素再入栈然后上方再执行出栈
                    return step + 1;
                }
                if(!visited[a]){  // 对于图中已经访问过的节点没有必要再次访问
                    queue.addLast(new Pair(a, step + 1));
                    visited[a] = true;
                }
            }
        }

        throw new IllegalStateException("No Solution.");
    }

    public static void main(String[] args) {

        System.out.println((new Solution3()).numSquares(12));
        System.out.println((new Solution3()).numSquares(13));
    }
}

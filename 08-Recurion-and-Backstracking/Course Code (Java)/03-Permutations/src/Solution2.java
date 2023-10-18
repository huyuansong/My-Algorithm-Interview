import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    private ArrayList<List<Integer>> res ;
    private boolean[] used;

    // 处理业务问题场景的函数
    public ArrayList<List<Integer>> permute(int[] nums ) {
        res = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0 ) {
            return res;
        }

        LinkedList<Integer> p = new LinkedList<>();
        used = new boolean[nums.length] ; Arrays.fill(used, false);
        generatePermute(nums , 0 , p ) ;

        return res ;

    }

    /**
     * 核心递归函数
     * @param nums 要排列的元素数组
     * @param index 接下来要处理的位数
     * @param p 已经处理的元素位数构成排列结果
     */
    private void generatePermute(int [] nums , int index , LinkedList<Integer> p ) {
        // 递归结束条件，已经得到一个答案 把满足答案的条件写在最前面是一种通用的代码模式
        if (index == nums.length ) {
            res.add((List<Integer>) p.clone());
            return;
        }

        for (int i = 0 ; i < nums.length ; i++ ) {
            if ( !used[i] ) {
                used[i] = true ;
                p.addLast(nums[i]);
                generatePermute(nums , index + 1 , p );
                p.removeLast(); // 不要写 pop
                used[i] = false ;
            }

        }
    }
    private static void printList(List<Integer> list){
        for ( Integer e : list ) {
            System.out.print(e + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int [] nums = {1 , 2 , 3 };
        List<List<Integer>> res = new Solution2().permute(nums);
         for ( List list : res ) {
             printList(list);
         }

    }
}
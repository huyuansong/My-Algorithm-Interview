import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Q：给定一个 nums ，求数组中的元素组成的排列数有哪些
 * 分析：这道题和手机按键数字母组合有所不同，那里的字母没有回溯的问题，用过的字母就不会再用了
 * 这里的数字是不同的，由于是排列问题，用过的数字还会再使用（只要顺序不同，就是不同的排列），所以要回溯
 * 回溯，需要借助第三方数据结构，一般会使用查找表，这里使用一个静态的数组就可以满足
 *
 */
public class Solution1 {

    private ArrayList<List<Integer>> res;
    private boolean[] used;

    // 处理业务问题的函数，做一些边界情况的检查和处理，准备功能函数需要的一些辅助空间
    public List<List<Integer>> permute(int[] nums) {

        res = new ArrayList<List<Integer>>();

        // 用户输入边缘情况处理
        if(nums == null || nums.length == 0)
            return res;

        // 开辟辅助空间
        used = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<Integer>();

        // 从设计角度考虑，单独再设立一个函数处理纯技术方向的问题
        generatePermutation(nums, 0, p);

        return res;
    }

    // p中保存了一个有index-1个元素的排列。
    // 向这个排列的末尾添加第index个元素, 获得一个有index个元素的排列
    private void generatePermutation(int[] nums, int index, LinkedList<Integer> p){

        if(index == nums.length){ // 递归的结束条件，当递归的深度到达要求，开始结束递归，p中累计的就是结果
            res.add((LinkedList<Integer>)p.clone());
            return;
        }

        for(int i = 0 ; i < nums.length ; i ++)
            if(!used[i]){

                used[i] = true;
                p.addLast(nums[i]); // 将当前元素考虑在结果中

                generatePermutation(nums, index + 1, p ); // 递归处理后一位元素

                // 写在递归结束后，去除上一轮排列对下一轮排列的影响
                p.removeLast(); // 回溯法，去除原来已经使用过的元素的影响，排列后面还可以用
                used[i] = false;
            }

        return;
    }

    private static void printList(List<Integer> list){
        for(Integer e: list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 2 , 3 };
        List<List<Integer>> res = (new Solution1()).permute(nums);
        for(List<Integer> list: res)
            printList(list);
    }
}

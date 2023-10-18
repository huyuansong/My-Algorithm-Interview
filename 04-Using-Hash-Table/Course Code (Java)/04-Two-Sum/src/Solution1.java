import java.util.HashMap;

// 1. Two Sum
// https://leetcode.com/problems/two-sum/description/
/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，
 * 并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * */
/** 由于题目中可以假设每种输入只会对应一个答案，只要求求出一个答案，
 *  因此可以在最初的时候遍历整个数组, 将数组中的每个数字的索引放在map中。
    此时, record是个Map，Map键不能相等，所以其中记录的永远是相等数字最后出现的位置（覆盖了之前记录的值）
    而对于 target = 2*a的情况, 如果nums中有两个或两个以上a,
    因为遍历了2遍，我们在扫描时会先看到第一个a, 此题凑巧的点在于，而record中被覆盖的是第一个a，存储的是第二个a的索引
    所以依旧可以一次性全部记录下所有元素的位置到Map中
 */
//
// 时间复杂度：O(n)
// 空间复杂度：O(n)
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
        // 一次性记录下所有元素出现的位置 Map（元素，位置）,若有重复的元素，后面元素的位置会覆盖前面出现元素的位置
        for(int i = 0 ; i < nums.length ; i ++)
            record.put(nums[i], i);

        for(int i = 0 ; i < nums.length; i ++){
            Integer index = record.get(target - nums[i]);
            if(index != null && index != i){ // 在Map中找到了，且不是 i 元素自身
                int[] res = {i, index};
                return res;
            }
        }

        throw new IllegalStateException("the input has no solution");
    }

    private static void printArr(int[] nums){
        for(int num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {0,4,3,0};
        int target = 0;
        printArr((new Solution2()).twoSum(nums, target));
    }
}

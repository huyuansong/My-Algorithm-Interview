import java.util.HashMap;

// 1. Two Sum
// https://leetcode.com/problems/two-sum/description/
/**
* 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，
* 并返回它们的数组下标。
* 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
* 你可以按任意顺序返回答案。
* */
// 由于不在乎顺序，所以使用 Hash。由于要返回元素所在的索引，所以需要一个 Map<元素值，索引> 。综合以上，使用 HashMap
// 时间复杂度：O(n)
// 空间复杂度：O(n)
public class Solution2 {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> recordMap = new HashMap<Integer, Integer>();
        /** 先在Map中查找元素是否存在，存在就返回，不存在再向其中加入新元素，避免产生相同元素的覆盖问题
         也因为题目说：可以假设每种输入只会对应一个答案,这里返回的是第一个答案，进一步也可以返回后续的答案
         如果有 2a 问题，这里的 i 是后一个元素，recordMap 中存放的是第一个元素
         其实，这是一种非常标准的代码写法，结束条件写在程序的最前面，然后再写核心的逻辑
         */
        for(int i = 0 ; i < nums.length; i ++){
            int complement = target - nums[i];
            if(recordMap.containsKey(complement)){
                int[] res = {i, recordMap.get(complement)};
                return res;
            }
            // 这种找到满足条件答案就立即返回的写法，能够提高程序的效率
            recordMap.put(nums[i], i);
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

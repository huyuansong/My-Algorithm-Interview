import java.util.TreeSet;
// 220. Contains Duplicate III
// https://leetcode.com/problems/contains-duplicate-iii/description/
/**
 * 给你一个整数数组 nums 和两个整数 indexDiff 和 valueDiff 。
 * 找出满足下述条件的下标对 (i, j)：
 * i != j,
 * abs(i - j) <= indexDiff
 * abs(nums[i] - nums[j]) <= valueDiff
 * 如果存在，返回 true ；否则，返回 false 。
 */
/**
 * 和上一题比，依旧是需要使用查找表，只是这里需要比较元素的大小，因此需要查找表有序，所以使用 Tree 做底层结构
 * 由于只需要记录单项数据，所以使用 Set 而非 Map ，综合以上，选用 TreeSet 做为查找表，借用标准库中的 ceiling()
 */
// 时间复杂度: O(nlogk)
// 空间复杂度: O(k)
public class Solution {

    /**
     * 判断索引差范围为k,值差范围为 t , 是否存在近似相等元素
     * @param nums 提供用于判断的数组
     * @param k 索引差的范围为 k
     * @param t 值差的范围为 t
     * @return 是否存在
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        // 这个问题的测试数据在使用int进行加减运算时会溢出 所以使用long long
        TreeSet<Integer> record = new TreeSet<Integer>();
        for(int i = 0 ; i < nums.length ; i ++){

            // Returns the least element in this set greater than or equal to the given element, or null if there is no such element.
            // ceiling(i) 返回比 i 大的最小元素，常常用在判断误差的场景
            // 在向查找表添加新元素之前，先写清楚退出条件：record中存在误差范围内的值
            if(record.ceiling(nums[i] - t) != null &&
                    record.ceiling(nums[i] - t) <= nums[i] + t ) // 因为 abs(nums[i] - nums[j]) <= t
            return true;

            record.add(nums[i]); // 向查找表中添加值，加入缓存

            if(record.size() == k + 1) // 维护一个 滑动窗口 的索引范围 （缓存大小）
                // 这里借用数组的有序性，而无需要求查找表 record 有序，只把元素从查找表移除就行
                record.remove(nums[i-k]); //（从缓存中逐出元素）
        }

        return false;
    }

    private static void printBool(boolean b){
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {

        int[] nums = {-2147483648, -2147483647};
        int k = 3;
        int t = 3;
        printBool((new Solution()).containsNearbyAlmostDuplicate(nums, k, t));
    }
}

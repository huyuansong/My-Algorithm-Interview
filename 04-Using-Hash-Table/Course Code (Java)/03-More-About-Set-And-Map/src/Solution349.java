import java.util.HashSet;

// 349. Intersection of Two Arrays
// https://leetcode.com/problems/intersection-of-two-arrays/description/
/** 349. Intersection of Two Arrays
 *  给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序
    因为这里不考虑顺序，所以可以使用hash作为底层数据结构，速度更快为常量。
    并且，我们分析得出：结果中的每个元素一定是 唯一 的，所以可以由之前实现的Map换成Set
    （虽然 Map 中不允许存放键相同的元素，后面的值会覆盖前面的值，但是value 部分可以使用动态数组存放多个值）
 */

// 时间复杂度: O(len(nums1)+len(nums2)) = O(1)
// 空间复杂度: O(len(nums1))
public class Solution349 {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> record = new HashSet<Integer>();
        // 将第一个数组中的元素存入到 hash 表中
        for(int num: nums1)
            record.add(num);

        HashSet<Integer> resultSet = new HashSet<Integer>();
        for(int num: nums2)
            if(record.contains(num)) // 如果第一个hash表中存在该元素，将其加入到最后结果hash表中
                resultSet.add(num);

        // 将结果转移到数组中
        int[] res = new int[resultSet.size()];
        int index = 0;
        for(Integer num: resultSet)
            res[index++] = num;

        return res;
    }

    private static void printArr(int[] arr){
        for(int e: arr)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = (new Solution349()).intersection(nums1, nums2);
        printArr(res);
    }
}
import java.util.TreeMap;
import java.util.ArrayList;

// 350. Intersection of Two Arrays II
// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/

/**
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
 * 可以不考虑输出结果的顺序。
 */
/**
 * 因为要考虑出现的次数，所以要map结构存储 数字+频率 两部分
 * 因为不考虑顺序，所以考虑使用HashMap，这里先使用有序的TreeMap
 */
// 时间复杂度: O(nlogn)
// 空间复杂度: O(n)
public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {

        TreeMap<Integer, Integer> record = new TreeMap<Integer, Integer>();
        for(int num: nums1)
            if(!record.containsKey(num))
                record.put(num, 1);
            else
                record.put(num, record.get(num) + 1);

        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int num: nums2)
            if(record.containsKey(num) && record.get(num) > 0){
                result.add(num);
                record.put(num, record.get(num) - 1);
            }

        // 将list中的元素转移到数组中来
        int[] ret = new int[result.size()];
        int index = 0;
        for(Integer num: result)
            ret[index++] = num;

        return ret;
    }

    private static void printArr(int[] arr){
        for(int e: arr)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = (new Solution()).intersect(nums1, nums2);
        printArr(res);
    }
}

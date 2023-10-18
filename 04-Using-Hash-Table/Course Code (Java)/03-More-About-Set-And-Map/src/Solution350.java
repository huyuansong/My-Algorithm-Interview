import java.util.HashMap;
import java.util.ArrayList;

// 350. Intersection of Two Arrays II
// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
/**
* 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
* 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
* 可以不考虑输出结果的顺序。
* */
 /**不考虑顺序，则底层选用Hash。考虑次数，则使用Map结构。综合以上，使用HashMap*/
// 时间复杂度: O(len(nums1)+len(nums2)) == O(1)
// 空间复杂度: O(len(nums1))
public class Solution350 {

    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
        // 将 nums1 中的每一个元素全部加入到HashMap中
        for(int num: nums1)
            if(!record.containsKey(num))
                record.put(num, 1);
            else
                record.put(num, record.get(num) + 1);

        // 用来存放结果的数据结构，由于数据经常发生写操作，所以这里使用 动态数组 ，后续再将其转为 静态数组
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int num: nums2)
            if(record.containsKey(num) && record.get(num) > 0){
                result.add(num);
                record.put(num, record.get(num) - 1);
            }

        // 将 动态数组 中的元素转移到符合题意要求的 静态数组 中
        int[] ret = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ret[i] = result.get(i);
        }

        /*
        个人觉得上面的逻辑比下面这种新式的写法 可读性 高
        int index = 0;
        for(Integer num: result)
            ret[index++] = num;*/

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
        int[] res = (new Solution350()).intersect(nums1, nums2);
        printArr(res);
    }
}
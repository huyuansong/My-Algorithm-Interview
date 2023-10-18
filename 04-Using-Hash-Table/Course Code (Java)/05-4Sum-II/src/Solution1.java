import java.util.HashMap;

// 454. 4Sum II
// https://leetcode.com/problems/4sum-ii/description/
/***
 *   给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 *   0 <= i, j, k, l < n
 *   nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *   提示：
 *      n == nums1.length
 *      n == nums2.length
 *      n == nums3.length
 *      n == nums4.length
 *      1 <= n <= 200   10^3 ^2 = 10^6 << 10^8 所以，一个 O(n^2)就可以达到要求
 *      -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
 */
// 时间复杂度: O(n^2)
// 空间复杂度: O(n^2)
public class Solution1 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        if(A == null || B == null || C == null || D == null)
            throw new IllegalArgumentException("Illegal argument");

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 将 C + D 和的值存放在 Map 中
        for(int i = 0 ; i < C.length ; i ++)
            for(int j = 0 ; j < D.length ; j ++){
                int sum = C[i] + D[j];
                if(map.containsKey(sum))
                    map.put(sum, map.get(sum) + 1);  // 统计有 sum 值的元素 的 个数
                else
                    map.put(sum, 1);
            }

        int res = 0; // 题中只是问有多少个元组，这里只是一个 int 就够了
        for(int i = 0 ; i < A.length ; i ++)
            for(int j = 0 ; j < B.length ; j ++)
                if(map.containsKey(-A[i]-B[j]))
                    res += map.get(-A[i]-B[j]);  // 看 map 中有 符合要求值 的 个数

        return res;
    }

    public static void main(String[] args) {

        int[] a = {1, 2};
        int[] b = {-2, -1};
        int[] c = {-1, 2};
        int[] d = {0, 2};
        System.out.println((new Solution1()).fourSumCount(a, b, c, d));
    }
}

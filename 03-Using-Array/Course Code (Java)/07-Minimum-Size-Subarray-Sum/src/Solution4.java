// 209. Minimum Size Subarray Sum
// https://leetcode.com/problems/minimum-size-subarray-sum/description/
//
// 另外一个滑动窗口的实现, 仅供参考。没有上一种方式实现的逻辑清晰
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution4 {

    public int minSubArrayLen(int s, int[] nums) {

        if(s <= 0 || nums == null)
            throw new IllegalArgumentException("Illigal Arguments");

        int l = 0 , r = -1; // [l...r]为我们的窗口
        int sum = 0;
        int res = nums.length + 1;

        // 整个问题依旧在有意义的空间范围内
        while(r + 1 < nums.length){

            // 单独考虑右侧窗口
            while(r + 1 < nums.length && sum < s) { // 右侧还能移动，且需要扩大==>那么就右移
                sum += nums[++r];
                if (sum >= s) // 窗口停止滑动的结束条件，在滑动之前，先判断是否产生了一个满足题意的结果
                    res = Math.min(res, r - l + 1);
            }

            // 单独考虑左侧窗口
            while(l < nums.length && sum >= s){
                sum -= nums[l++];
                if(sum >= s)
                    res = Math.min(res, r - l + 1);
            }
        }

        if(res == nums.length + 1)
            return 0;
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println((new Solution4()).minSubArrayLen(s, nums));
    }
}

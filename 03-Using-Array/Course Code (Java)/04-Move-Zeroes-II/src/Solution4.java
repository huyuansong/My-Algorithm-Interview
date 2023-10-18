// 283. Move Zeroes
// https://leetcode.com/problems/move-zeroes/description/
//
// 原地(in place)解决该问题 这种问题一般要画图，画图不能节省空间，能把问题梳理清楚，多少空间都值得
// 时间复杂度: O(n)
// 空间复杂度: O(1)
class Solution4 {

    public void moveZeroes(int[] nums) {

        int k = 0; // nums中, [k...nums.length)的元素为 0, k 记录的是 0 元素的起始位置

        // 遍历到第i个元素后,保证[0...i]中所有非0元素
        // 都按照顺序排列在[0...k)中
        // 同时, [k...i] 为 0
        for(int i = 0 ; i < nums.length ; i ++)
            if(nums[i] != 0)
                if(k != i)  // 避免了自身和自身交换
                    swap(nums, k++, i);
                else
                    k ++;
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String args[]){

        int[] arr = {0, 1, 0, 3, 12};

        (new Solution4()).moveZeroes(arr);

        for(int i = 0 ; i < arr.length ; i ++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
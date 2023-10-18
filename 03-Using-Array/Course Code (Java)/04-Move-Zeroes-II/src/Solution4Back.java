import java.util.Arrays;

public class Solution4Back {
    /**
     * 将nums中非零元素移动到最前面
     * ！！！要求原地，原地一般要想到交换
     * 这个思路要想到是不容易的，实现是容易的，画图
     *
     * @param nums 需要处理的数组
     */
    public void moveZeroes(int[] nums) {

        // nums中, [0...k)的元素为 非 0, k 记录的是 0 元素的起始位置
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (k != i) {
                    swap(nums, k, i);
                } else {
                    k++;
                }
            }
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution4Back().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}

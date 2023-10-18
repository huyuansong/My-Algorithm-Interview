import java.util.Arrays;

public class Solution3Back {
    /**
     * 将nums中非零元素移动到最前面
     * ！！！要求原地，原地一般要想到交换
     * 这个思路要想到是不容易的，实现是容易的
     * @param nums 需要处理的数组
     */
    public void moveZeroes(int[] nums) {

        // 重新记录索引放新元素的位置
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, k++, i);
            }

        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i] ;
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 4, 2, 0, 1, 4};
        new Solution3Back().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}

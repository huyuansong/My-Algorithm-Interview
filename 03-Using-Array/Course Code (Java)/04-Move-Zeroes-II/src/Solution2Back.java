import java.util.Arrays;

public class Solution2Back {
    /**
     * 将nums中非零元素移动到最前面
     *
     * @param nums 需要处理的数组
     */
    public void moveZeroes(int[] nums) {

        // 重新记录索引放新元素的位置
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i]; // 如果是 0 会被覆盖掉，如果不是 0 ， 在 i 的时候已经处理过了
            }

        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }


    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 4, 2, 0, 1, 4};
        new Solution2Back().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}

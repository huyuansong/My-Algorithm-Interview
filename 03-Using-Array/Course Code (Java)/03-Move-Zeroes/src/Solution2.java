import java.util.ArrayList;
import java.util.Arrays;

/**
 * 练手写一遍
 */
public class Solution2 {

    /**
     * 将nums中的非零元素放在数组的前面，零元素放在后面
     *
     * @param nums 要操作的数组
     */
    public void moveZeroes(int[] nums) {

        // 准备一个动态数组供使用
        ArrayList<Integer> noneZeroArray = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                noneZeroArray.add(nums[i]);
            }
        }

        int k = 0;
        for (; k < noneZeroArray.size(); ) {
            nums[k] = noneZeroArray.get(k++); // 这种代码风格很极端，注意写在后面出现的 k 上，否则越界
        }

        for (; k < nums.length;) {
            nums[k++] = 0;
        }


    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 4, 0, 7, 3};
        new Solution2().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }

}

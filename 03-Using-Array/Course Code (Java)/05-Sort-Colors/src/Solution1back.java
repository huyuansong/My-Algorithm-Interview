import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * <p>
 * 计数排序
 */
public class Solution1back {
    /**
     * 要求将数组排序为 0 1 2 的存储方式
     *
     * @param nums 原始只有012三种元素的数组
     */
    public void sortColors(int[] nums) {
        int[] count = new int[nums.length]; Arrays.fill(count,0);

        for (int i = 0; i < nums.length; i++) {
            assert nums[i] >= 0 && nums[i] <= 2;
            count[nums[i]]++;
        }

        int k = 0;
        for (int j = 0; j < count.length; j++) { // 挨个统计元素的频率
            while (count[j] > 0) {
                nums[k++] = j; // 使用k作为索引，能够减少一轮没必要的循环，统计每一个频率下有多少个i，i不变
                count[j]--;
            }
        }

        /**
         *  int l = 0 ;
            for (int i = 0; i < count.length; i++) { // 挨个统计元素的频率
                for (; count[i] > 0; count[i]--) {
                    nums[l++] = i;
                }
            }
         */

    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 0, 0, 0};
        new Solution1back().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }


}

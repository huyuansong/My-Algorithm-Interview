

public class Solution2Back {

    public void sortColors(int[] nums) {

        // 划定区间 [zero+1 , two-1] == 1
        int zero = -1; // [0,zero] ==0
        int two = nums.length; // [two,n-1] == 2

        for (int i = 0; i < two; ) {
            if (nums[i] == 1 )
                i++;
            else if (nums[i] == 2) {
                swap(nums , i , --two);
            }else {
                assert nums[i] == 0;
                swap(nums, i++ , ++zero ) ;
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

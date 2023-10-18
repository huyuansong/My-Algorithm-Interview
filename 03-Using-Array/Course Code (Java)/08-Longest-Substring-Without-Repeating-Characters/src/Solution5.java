// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
//
// 滑动窗口 + 静态数组做缓存查找
// 其中使用last[c]保存字符c上一次出现的位置, 用于在右边界发现重复字符时, 快速移动左边界
// 使用这种方法, 时间复杂度依然为O(n), 但是只需要动r指针, 实际上对整个s只遍历了一次
// 相较而言, 之前的方法, 需要移动l和r两个指针, 相对于对s遍历了两次

import java.util.Arrays;

// 时间复杂度: O(len(s))
// 空间复杂度: O(len(charset))
public class Solution5 {

    public int lengthOfLongestSubstring(String s) {

        int[] last = new int[256]; // 存放对应的字母上一次出现的位置索引
        Arrays.fill(last, -1); // 数组初始化为 -1

        int l = 0, r = -1; //滑动窗口为s[l...r]，其中无重复元素
        int res = 0;
        while(r + 1 < s.length()){

            r ++;

            if(last[s.charAt(r)] != -1) // 说明该元素之前已经出现过
                l = Math.max(l, last[s.charAt(r)] + 1);

            res = Math.max(res, r - l + 1);

            last[s.charAt(r)] = r; // 无论左侧是否移动，r 都进行了右移，在循环的最后需要更新 r 字母最新的位置索引
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution5()).lengthOfLongestSubstring( "abcabcbb" ));
        System.out.println((new Solution5()).lengthOfLongestSubstring( "bbbbb" ));
        System.out.println((new Solution5()).lengthOfLongestSubstring( "pwwkew" ));
        System.out.println((new Solution5()).lengthOfLongestSubstring( "" ));
    }
}

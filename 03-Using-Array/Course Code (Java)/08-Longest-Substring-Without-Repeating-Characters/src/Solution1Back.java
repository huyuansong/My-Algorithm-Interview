// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
// 滑动窗口 + 查找表记录频率
// 时间复杂度: O(len(s))
// 空间复杂度: O(len(charset))
class Solution1Back {
    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256]; // 字符表的长度  ASCII码表一共128个字符，区分大小写，这里取 256

        int l = 0, r =  -1; //滑动窗口为s[l...r] ,区间中不能有一个元素，否则第一个元素的频率是没有被统计上的！！！
        int res = 0;

        // 整个循环从 l == 0; r == -1 这个空窗口开始
        // 滑动窗口为s[l...r] 中不能有重复的元素
        while(l < s.length()){

            if(r + 1 < s.length() && freq[s.charAt(r+1)] == 0) { // 还可以向后移动，且新元素之前没出现过
                ++r;
                int count1 = freq[s.charAt(r)]++;
                System.out.format("此时s[l=%d , r=%d ]=%c  频率为：%d \n" , l , r, s.charAt(r) , count1 );
            }
            else {   //r已经到头 || freq[s[r+1]] == 1 无法再移动或者出现的不是新元素
                int count2 = freq[s.charAt(l)]--;
                l++;
                System.out.format("此时s[l=%d , r=%d ]=%c  频率为：%d \n" , l , r, s.charAt(r) , count2 );
            }

            res = Math.max(res, r-l+1); // 因为发生了移动，有可能产生新结果
            System.out.format("此时的最大区间为：[%d,%d]  长度=%d \n" , l, r  , r-l+1 );
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution1Back()).lengthOfLongestSubstring( "abcabcbb" ));
        /*System.out.println((new Solution1()).lengthOfLongestSubstring( "bbbbb" ));
        System.out.println((new Solution1()).lengthOfLongestSubstring( "pwwkew" ));
        System.out.println((new Solution1()).lengthOfLongestSubstring( "" ));*/
    }
}
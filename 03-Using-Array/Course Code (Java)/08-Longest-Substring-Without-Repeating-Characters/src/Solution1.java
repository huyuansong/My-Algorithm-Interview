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
class Solution1 {
    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256]; // 字符表的长度  ASCII码表一共128个字符，区分大小写，这里取 256

        int l = 0, r = -1; //滑动窗口为s[l...r],必须从空窗口开始，否则在后续的循环中，第一个元素是被统计频率的
        int res = 0;

        // 在每次循环里逐渐改变窗口, 维护freq, 并记录当前窗口中是否找到了一个新的最优值
        // 滑动窗口为s[l...r]，维持住区间中没有一个重复的元素
        while(l < s.length()){

            if(r + 1 < s.length() && freq[s.charAt(r+1)] == 0) // 还可以向后移动，且新元素之前没出现过
                freq[s.charAt(++r)] ++;
            else    //r已经到头 || freq[s[r+1]] == 1 无法再移动或者出现的不是新元素
                freq[s.charAt(l++)] --;

            res = Math.max(res, r-l+1); //根据定义的逻辑，闭区间求长度
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution1()).lengthOfLongestSubstring( "abcabcbb" ));
        /*System.out.println((new Solution1()).lengthOfLongestSubstring( "bbbbb" ));
        System.out.println((new Solution1()).lengthOfLongestSubstring( "pwwkew" ));
        System.out.println((new Solution1()).lengthOfLongestSubstring( "" ));*/
    }
}
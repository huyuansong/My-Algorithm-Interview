// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
//
// 滑动窗口的另一个实现, 仅做参考
// 时间复杂度: O(len(s))
// 空间复杂度: O(len(charset))
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256];

        int l = 0, r = -1; //滑动窗口为s[l...r]
        int res = 0;

        while(r + 1 < s.length()){

            while(r + 1 < s.length() && freq[s.charAt(r+1)] == 0) {
                freq[s.charAt(++r)] ++;
            }

            res = Math.max(res, r - l + 1);

            // 之前的写法是当元素要出现重复就开始移动左侧窗口，这种写法是已经出现重复元素，还统计进来，然后再移动左侧去除
            // 对于s[l...r]的维护是没有严格遵守定义，所以这里统计长度的写法要放在这轮循环的上面，不推荐这种写法
            if(r + 1 < s.length()){
                freq[s.charAt(++r)] ++;
                assert(freq[s.charAt(r)] == 2);
                while(l <= r && freq[s.charAt(r)] == 2)
                    freq[s.charAt(l++)] --;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution3()).lengthOfLongestSubstring( "abcabcbb" ));
        System.out.println((new Solution3()).lengthOfLongestSubstring( "bbbbb" ));
        System.out.println((new Solution3()).lengthOfLongestSubstring( "pwwkew" ));
        System.out.println((new Solution3()).lengthOfLongestSubstring( "" ));
    }
}

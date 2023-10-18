import java.util.Arrays;

/// 455. Assign Cookies
/// https://leetcode.com/problems/assign-cookies/description/
/// 先尝试满足最贪心的小朋友
/// 时间复杂度: O(nlogn)
/// 空间复杂度: O(1)
public class Solution {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);  // g 贪心的小朋友
        Arrays.sort(s);  // s 能够分配的饼干

        int gi = g.length - 1, si = s.length - 1; // 先满足最大值
        int res = 0;
        while(gi >= 0 && si >= 0){
            if(s[si] >= g[gi]){
                res ++;
                si --;  // 能满足这个小朋友，才把这个饼干分配出去
            }
            gi --; // 这个小盆友无论如何也无法满足，所以在 if 外 gi--
        }

        return res;
    }

    public static void main(String[] args) {

        int g1[] = {1, 2, 3};
        int s1[] = {1, 1};
        System.out.println((new Solution()).findContentChildren(g1, s1));

        int g2[] = {1, 2};
        int s2[] = {1, 2, 3};
        System.out.println((new Solution()).findContentChildren(g2, s2));
    }
}

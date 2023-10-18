import java.util.Arrays;
import java.util.Comparator;

/// 435. Non-overlapping Intervals
/// https://leetcode.com/problems/non-overlapping-intervals/description/

/**无重叠区间
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。
 * 返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 *
 * 示例 1:
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 *
 * solution：求解移除最少的区间，就是保留最多的区间，那就可以考虑贪心的方案
 * /// 动态规划
 * /// 时间复杂度: O(n^2)
 * /// 空间复杂度: O(n)
 */

public class Solution1 {

    // Definition for an interval.
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int eraseOverlapIntervals(Interval[] intervals) { // Overlap 重叠

        if(intervals.length == 0)
            return 0;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start != o2.start)
                    return o1.start - o2.start;
                return o1.end - o2.end;
            }
        });

        // memo[i]表示以intervals[i]为结尾的区间能构成的最长不重叠区间序列
        int[] memo = new int[intervals.length];
        Arrays.fill(memo, 1);
        for(int i = 1 ; i < intervals.length ; i ++)
            // memo[i]
            for(int j = 0 ; j < i ; j ++)
                if(intervals[i].start >= intervals[j].end)
                    memo[i] = Math.max(memo[i], 1 + memo[j]);

         // 求解一个数组中的最大值，标准的写法：打擂台
        int res = 0;
        for(int i = 0; i < memo.length ; i ++)
            res = Math.max(res, memo[i]);

        return intervals.length - res;
    }

    public static void main(String[] args) {
        Interval[] interval1 = {new Interval(1,2),
                                new Interval(2,3),
                                new Interval(3,4),
                                new Interval(1,3)};
        System.out.println((new Solution1()).eraseOverlapIntervals(interval1));

        Interval[] interval2 = {new Interval(1,2),
                                new Interval(1,2),
                                new Interval(1,2)};
        System.out.println((new Solution1()).eraseOverlapIntervals(interval2));

        Interval[] interval3 = {new Interval(1,2),
                                new Interval(2,3)};
        System.out.println((new Solution1()).eraseOverlapIntervals(interval3));
    }
}

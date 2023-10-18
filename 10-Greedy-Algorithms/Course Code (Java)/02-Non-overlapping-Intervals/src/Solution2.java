import java.util.Arrays;
import java.util.Comparator;

/// 435. Non-overlapping Intervals
/// https://leetcode.com/problems/non-overlapping-intervals/description/
/// 贪心算法 ，代码写起来比动态规划简单，但是要证明贪心适合使用不是一件简单的事情（反证法）
/// 时间复杂度: O(n)
/// 空间复杂度: O(n)
public class Solution2 {

    // Definition for an interval.
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int eraseOverlapIntervals(Interval[] intervals) {

        if(intervals.length == 0)
            return 0;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.end != o2.end)
                    return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });

        int res = 1;
        int pre = 0; // 记录已经选中的上升区间们的最后一个区间的索引
        for(int i = 1 ; i < intervals.length ; i ++)
            if(intervals[i].start >= intervals[pre].end){ // 存在继续上升的区间
                res ++;
                pre = i;
            }

        return intervals.length - res;
    }

    public static void main(String[] args) {
        Interval[] interval1 = {new Interval(1,2),
                new Interval(2,3),
                new Interval(3,4),
                new Interval(1,3)};
        System.out.println((new Solution2()).eraseOverlapIntervals(interval1));

        Interval[] interval2 = {new Interval(1,2),
                new Interval(1,2),
                new Interval(1,2)};
        System.out.println((new Solution2()).eraseOverlapIntervals(interval2));

        Interval[] interval3 = {new Interval(1,2),
                new Interval(2,3)};
        System.out.println((new Solution2()).eraseOverlapIntervals(interval3));
    }
}

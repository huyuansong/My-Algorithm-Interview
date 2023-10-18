import java.util.HashMap;

// 447. Number of Boomerangs
// https://leetcode.com/problems/number-of-boomerangs/description/

/**
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。
 * 回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的欧式距离相等（需要考虑元组的顺序）。
 * 返回平面上所有回旋镖的数量。
 * Input: points = [[0,0],[1,0],[2,0]]
 * Output: 2
 * Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]].
 * Constraints:
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * All the points are unique.
 */
/**
 * 暴力的方法是三重循环，计算量达到了 10^9 以上太多，不是很合适。优化：将距离相同的点的个数存储在 Map 中
 * 计算距离是很消耗 cpu 的，我们不如把所有可能的点全部加入到查找表中，用空间换时间
 * 因为需要求： 平面上所有回旋镖的数量，还需要考虑元组顺序，那么就是一个排列问题。
 * 所以：只需要求 i和j 之间有多少个不同的距离就可以了，然后计算排列数
 */
// 时间复杂度: O(n^2)
// 空间复杂度: O(n)
public class Solution {

    public int numberOfBoomerangs(int[][] points) {

        int res = 0;
        for( int i = 0 ; i < points.length ; i ++ ){
            // record中存储 点i 到所有其他点 j 的距离出现的频次 , Map<距离大小,点的个数>
            // 以 i 为枢纽点，每次的距离都对应不同的 Map，因此，这个 Map 要写在 for 循环中
            HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();

            for(int j = 0 ; j < points.length ; j ++) {
                if (j != i) {   // i和 j 是两个不同的点
                    // 计算距离时不进行开根运算, 以保证精度
                    int dis = dis(points[i], points[j]);
                    if (record.containsKey(dis))
                        record.put(dis, record.get(dis) + 1);   // 将i j之间的距离存入Map中
                    else
                        record.put(dis, 1);
                }
            }


            for(Integer dis: record.keySet())
                res += record.get(dis) * (record.get(dis) - 1); // 需要考虑元组的顺序 （排列问题）
        }

        return res;
    }

    private int dis(int[] pa, int pb[]){
        return (pa[0] - pb[0]) * (pa[0] - pb[0]) +
               (pa[1] - pb[1]) * (pa[1] - pb[1]);
    }

    public static void main(String[] args) {

        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println((new Solution()).numberOfBoomerangs(points));
    }
}

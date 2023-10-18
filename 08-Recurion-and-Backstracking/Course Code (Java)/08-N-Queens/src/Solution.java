import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

/// 51. N-Queens
/// https://leetcode.com/problems/n-queens/description/
/// 时间复杂度: O(n^n)
/// 空间复杂度: O(n)
public class Solution {

    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;
    private ArrayList<List<String>> res;

    public List<List<String>> solveNQueens(int n) {

        res = new ArrayList<List<String>>();
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1]; // 对角线上的条数是 2n-1 条
        dia2 = new boolean[2 * n - 1];

        LinkedList<Integer> row = new LinkedList<Integer>();
        putQueen(n, 0, row);

        return res;
    }

    // 尝试在一个n皇后问题中, 摆放第index行的皇后位置
    private void putQueen(int n, int index, LinkedList<Integer> row){

        if(index == n){ // index 已经到了 n 行，说明已经得到了一个答案
            res.add(generateBoard(n, row));
            return;
        }

        for(int i = 0 ; i < n ; i ++)
            // 尝试将第index行的皇后摆放在第i列
            // 从左下到右上的对角线 一条对角线上的元素横纵坐标和相等 dia1[index + i] 判断是否为一条对角线
            // 从左上到右下的对角线 一条对角线上的元素横纵坐标差相等 但是 index-i 差最大为 -(n-1),全部元素加一个偏移量(n-1)
            if(!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]){
                row.addLast(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;

                putQueen(n, index + 1, row); // 一行一个递归函数，考虑下一行的摆放

                // 如果 上方的递归函数结束了，说明这些位置不能用，那么要把刚才占据的位置放开，回溯
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.removeLast();
            }

        return;
    }

    private List<String> generateBoard(int n, LinkedList<Integer> row){

        assert row.size() == n;

        ArrayList<String> board = new ArrayList<String>();
        // 用for循环将一个一位数组转换为二维数组
        for(int i = 0 ; i < n ; i ++){
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[row.get(i)] = 'Q';
            board.add(new String(charArray));
        }
        return board;
    }

    private static void printBoard(List<String> board){
        for(String s: board)
            System.out.println(s);
        System.out.println();
    }

    public static void main(String[] args) {

        int n = 4;
        List<List<String>> res = (new Solution()).solveNQueens(n);
        for(List<String> board: res)
            printBoard(board);
    }
}

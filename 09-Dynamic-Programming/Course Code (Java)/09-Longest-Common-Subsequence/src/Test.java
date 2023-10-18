import java.util.Arrays;

/// LCS问题
///  记忆化 递归
/// 时间复杂度: O(len(s1)*len(s2))
/// 空间复杂度: O(len(s1)*len(s2))
public class Test {
    public static void main(String[] args) {
        int [][] memo = new int[3][2];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i] , -1);
        }

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                System.out.print(memo[i][j] +" ");
            }
        }

    }
}


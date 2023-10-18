public class Main2 {
    // 递推和递归是两个相对应的过程，但是递推能完成的任务大很多
    // 递归受制于系统栈大小的限制，能计算的结果有限
    private static int sum1(int n){

        assert n >= 0;
        int ret = 0;
        for( int i = 0 ; i <= n ; i ++ )  // 递推
            ret += i;
        return ret;
    }

    private static int sum2(int n){

        assert n >= 0;
        if( n == 0 )
            return 0;

        return n + sum2(n-1);   // 递归
    }

    public static void main(String[] args) {

        System.out.println(sum1(10000));
        //System.out.println(sum2(10000));
    }
}

public class Main {

    public static void main(String[] args) {

        // 数据规模每次增大10倍进行测试
        // 有兴趣的同学也可以试验一下数据规模每次增大2倍哦:)
        // 这个案例是为了测试出一台常用计算机在 1 秒内的最大运算量大概在 10^9 次
        // 由于 Java 的机制，可能会有缓存加速之类的，但是不妨碍能够看出上面的规律
        for( int x = 1 ; x <= 9 ; x ++ ){

            int n = (int)Math.pow(10, x);

            long  startTime = System.nanoTime();

            long sum = 0;
            for( int i = 0 ; i < n ; i ++ )
                sum += i;

            long  endTime = System.nanoTime();

            //System.out.println("sum = " + sum);
            System.out.println("10^" + x + " : " + (endTime - startTime) / 1e9 + " s");

            System.out.println();
        }
    }
}

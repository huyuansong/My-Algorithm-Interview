
public class Main3 {

    public static void main(String[] args) {

        // 数据规模倍乘测试binarySearch
        // O(logn)
        System.out.println("Test for Binary Search:");
        for(int i = 10 ; i <= 28 ; i ++){

            int n = (int)Math.pow(2, i);
            Integer[] arr = MyUtil.generateOrderedArray(n);

            long startTime = System.nanoTime();
            MyAlgorithmTester.binarySearch(arr, n, 0);
            long endTime = System.nanoTime();

            System.out.print("data size 2^" + i + " = " + n + "\t");
            /*System.out.println("endTime:" + endTime);
            System.out.println("startTime:" + startTime);*/
            System.out.println("Time cost: " + (endTime - startTime) + " ms");
        }
    }
}

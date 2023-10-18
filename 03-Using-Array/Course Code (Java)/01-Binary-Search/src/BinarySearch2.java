public class BinarySearch2 {

    private BinarySearch2() {
    }

    /**
     * 二分查找法
     *  引入循环不变量的概念，维护概念有助于写出正确的代码
     * @param arr    用来查找的数组
     * @param n      查找元素的范围 [0,n)
     * @param target 要查找的元素值
     * @return 查找到的元素的位置索引，查找不到返回 -1
     */
    public static int binarySearch2(Comparable[] arr, int n, Comparable target) {
        int l = 0, r = n;
        // 查找 [l , r ) 范围内的target
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target.compareTo(arr[mid]) == 0 ) {
                return mid ;
            }

            if (target.compareTo(arr[mid]) < 0 ) {
                r = mid ;
            }else { // target > mid
                l = mid + 1;
            }

        }
        return -1 ;
    }


    public static void main(String[] args) {
        int n = (int) Math.pow(10, 7);
        Integer[] data = Util.generateOrderedArray(n);

        long startTime = System.nanoTime();

        for (int i = 0; i < n; i++) {
            // 在[0,n-1]的范围内寻找i , 因为i有序，所以i的索引==i的值
            if (i != binarySearch2(data, n, i)) {
                throw new IllegalStateException("find i failed!");
            }
        }

        long endTime = System.nanoTime();

        System.out.println("Binary Search test completed.");
        System.out.println("Time cost :" + (endTime - startTime));


    }

}

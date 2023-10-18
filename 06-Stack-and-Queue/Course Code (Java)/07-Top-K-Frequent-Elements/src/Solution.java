import java.util.*;
import java.util.HashMap;

import javafx.util.Pair;

// 347. Top K Frequent Elements
// https://leetcode.com/problems/top-k-frequent-elements/description/
/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
/**
 *  TopK selectK 问题：有两种解法，其一：优先队列 其二：三路快排
 *  1. 首先需要遍历一遍，统计出所有元素的频率。（对于任何问题，先想一个暴力的解法，然后再想优化的事情）
 *  2. 使用优先队列维护 k 个元素，使用打擂台的方式，把第一步中的频率数组所有元素都比较一遍
 *  3. 将优先队列中的所有元素全部转存到动态数组中
 */
// 时间复杂度: O(nlogk)
// 空间复杂度: O(n + k)
class Solution {

    private class PairComparator implements Comparator<Pair<Integer, Integer>>{

        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2){
            if(p1.getKey() != p2.getKey())
                return p1.getKey() - p2.getKey();
            return p1.getValue() - p2.getValue();
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        if(k <= 0)
            throw new IllegalArgumentException("k should be greater than 0");

        // 统计每个元素出现的频率
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < nums.length ; i ++)
            if(freq.containsKey(nums[i]))
                freq.put(nums[i], freq.get(nums[i]) + 1);
            else
                freq.put(nums[i], 1);

        if(k > freq.size())
            throw new IllegalArgumentException("k should be less than the number of unique numbers in nums");

        // 扫描freq,维护当前出现频率最高的k个元素
        // 在优先队列中,按照频率排序,所以数据对是 (频率,元素) 的形式
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>(new PairComparator());
        for(Integer num: freq.keySet()){
            int numFreq = freq.get(num);
            if(pq.size() == k){  // peek() Retrieves, but does not remove
                if(numFreq > pq.peek().getKey()){ //这里是最小堆，移除 TopK 中最小的元素
                    pq.poll(); // poll() Retrieves and removes
                    pq.add(new Pair(numFreq, num)); // 将当前参与比较的 num 加入到优先队列
                }
            }
            else  // 有限队列中的元素没有放满 k 个，将进来的所有元素先全部放入到队列中
                pq.add(new Pair(numFreq, num));
        }

        // 取出优先队列中的所有元素，转存在动态数组中
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(!pq.isEmpty())
            res.add(pq.poll().getValue());

        return res;
    }

    private static void printList(List<Integer> nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new Solution()).topKFrequent(nums, k));
    }
}

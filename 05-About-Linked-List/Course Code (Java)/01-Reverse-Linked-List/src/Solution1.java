// 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/description/

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * 这里一般而言不能改变元素节点的值，因此只能改变节点之间的指向
 * 需要一张纸，画出各个节点之间的状态，通过分析缺少什么，得到答案，需要 3 个指针记录三个位置
 * 一定要用纸和笔画图，别听一些人做作说一切都电子化，很多东西画图更容易看明白
 */
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution1 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        // pre 前一个位置 cur 当前位置 next 下一个位置
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}

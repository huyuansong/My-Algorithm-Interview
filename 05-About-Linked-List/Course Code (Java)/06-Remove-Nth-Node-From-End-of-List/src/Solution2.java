// 19. Remove Nth Node From End of List
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *  n不包含最后的 null 元素
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 */
/** 使用双指针, 对链表只遍历了一遍
 * 思路很简单，先用一个指针移动 n+1 位 ，然后再开始同步移动两个指针。先移动的指针始终比后移动的指针快 n+1 步
 * 等到第一个指针到达末尾的时候，第二个指针刚好在倒数第 n+1 个位置，也就是要删除元素的前一位
 * 尤其需要注意 移动位置 的边界条件
 */
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;
        // q `先`往后移动 n+1 位
        for( int i = 0 ; i < n + 1 ; i ++ ){
            assert q != null;
            q = q.next;
        }
        // p q 同步往后移动，q 一直移动到末尾的 null 为止
        while(q != null){
            p = p.next; // p 在要删除元素的前一位
            q = q.next; // 末尾的 null
        }

        p.next = p.next.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        System.out.println(head);

        head = (new Solution2()).removeNthFromEnd(head, 2);
        System.out.println(head);
    }
}

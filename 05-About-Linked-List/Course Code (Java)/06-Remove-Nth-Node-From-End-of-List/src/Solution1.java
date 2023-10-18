// 19. Remove Nth Node From End of List
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *  n不包含最后的 null 元素
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 */

// 先记录链表总长度
// 需要对链表进行两次遍历
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution1 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 统计链表的长度
        int length = 0;
        for(ListNode cur = dummyHead.next ; cur != null ; cur = cur.next)
            length ++;

        // 计算出从前往后数的位置，然后将指针移动到要删除元素k的前一位
        int k = length - n;
        assert k >= 0;
        ListNode cur = dummyHead;
        for(int i = 0 ; i < k ; i ++)
            cur = cur.next;

        // 执行删除操作
        cur.next = cur.next.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        System.out.println(head);

        head = (new Solution1()).removeNthFromEnd(head, 2);
        System.out.println(head);
    }
}

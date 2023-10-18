// 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/description/
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution {

    // 函数的定义：传入要翻转链表的头节点，返回翻转后的链表的头节点
    public ListNode reverseList(ListNode head) {

        if(head == null){
            return head;
        }
        if (head.next == null ) {
            return head;
        }

        // 这里得到一个 头为 rHead ，尾巴为 head.next 的 链表
        ListNode rHead = reverseList(head.next);

        // 函数带返回值，这里可以再加一部分逻辑，这里才是真正的翻转逻辑
        head.next.next = head;
        head.next = null;

        return rHead;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2 ,3 , 4};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode head2 = (new Solution()).reverseList(head);
        System.out.println(head2);
    }
}

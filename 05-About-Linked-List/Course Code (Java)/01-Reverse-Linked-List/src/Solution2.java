// 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/description/
//
// 递归的方式反转链表
// 时间复杂度: O(n)
// 空间复杂度: O(n) - 注意，递归是占用空间的，占用空间的大小和递归深度成正比：）
public class Solution2 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 明确函数的语意很重要，想不清楚的时候就要画图
     * @param head 传入的是以 head 为头节点的链表
     * @return 返回的是一个 ListNode 类型 为头节点，head 为尾巴节点的，翻转之后的链表
     */
    public ListNode reverseList(ListNode head) {

        // 递归终止条件
        if(head == null|| head.next == null)
            return head;

        // 既然这是一个递归函数，传入的变量参数一定要有所变化，不能和原始函数一模一样，只能是下一步的增改
        // 这里得到一个 头为 rHead ，尾巴为 head.next 的 链表
        ListNode rHead = reverseList(head.next);

        // 递归函数调用后，使的有一个元素未处理，需要步进式的手动处理该特殊元素
        // head->next此刻指向head后面的链表的尾节点，翻转后的 head 其实是链表中还没有接上的尾部
        // head->next->next = head把head节点放在了反转之后的链表的尾部
        head.next.next = head;
        head.next = null;

        return rHead;
    }
}

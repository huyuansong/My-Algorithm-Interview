// 237. Delete Node in a Linked List
// https://leetcode.com/problems/delete-node-in-a-linked-list/description/
/**
 * 有一个单链表的 head，我们想删除它其中的一个节点 node。
 * 给你一个需要删除的节点 node 。你将 无法访问 第一个节点  head。
 * 链表的所有值都是 唯一的，并且保证给定的节点 node 不是链表中的最后一个节点。
 * 删除给定的节点。注意，删除节点并不是指从内存中删除它。这里的意思是：
 * 给定节点的值不应该存在于链表中。
 * 链表中的节点数应该减少 1。
 * node 前面的所有值顺序相同。
 * node 后面的所有值顺序相同。
 * 自定义测试：
 *
 * 对于输入，你应该提供整个链表 head 和要给出的节点 node。node 不应该是链表的最后一个节点，而应该是链表中的一个实际节点。
 * 我们将构建链表，并将节点传递给你的函数。
 * 输出将是调用你函数后的整个链表。
 */

/**
 * 这道题很有意思，读懂题目很重要，意思是：知道要删除的节点是什么，但是不知道这个节点的前一个节点
 * 解决办法：将后一个元素移动到当前的位置，然后删除后一个元素。相当于用后一个元素覆盖了当前要删除的元素，然后删除重复的元素
 */
// 时间复杂度: O(1)
// 空间复杂度: O(1)
public class Solution {

    public void deleteNode(ListNode node) {

        // 注意: 这个方法对尾节点不适用。题目中要求了给定的node不是尾节点
        // 我们检查node.next, 如果为null则抛出异常, 确保了node不是尾节点
        if(node == null || node.next == null)
            throw new IllegalArgumentException("node should be valid and can not be the tail node.");
        // 两句话解决当前题目！！！
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};

        ListNode head = new ListNode(arr);
        System.out.println(head);

        ListNode node2 = head.findNode(2);
        (new Solution()).deleteNode(node2);
        System.out.println(head);
    }
}

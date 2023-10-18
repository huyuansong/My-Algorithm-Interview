// 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/description/
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class SolutionBack {

    public ListNode reverseList(ListNode head) {

        // 特殊输入情况
        if(head == null){
            return head;
        }
        // 递归终止条件，只有 1 个元素的时候如何翻转
        if (head.next == null ) {
            System.out.printf("递归到底，链表只有一个元素%d，在这里返回 \n" , head.val );
            return head;
        }

        // 因为这是一个递归函数，写代码的时候只需要考虑宏观语意就可以了,明确这里最终达成什么样的效果
        // 这里得到一个 头为 rHead ，尾巴为 head.next 的 链表
        System.out.printf("将%d作为头节点传入递归函数 \n", head.next.val );
        ListNode rHead = reverseList(head.next);
        System.out.print("递归函数执行完，得到的链表为 " + rHead );
        System.out.println(" 但是不返回，在返回之前，将下一个节点关联上");

        // 因为递归函数有返回值，所以可以在函数调用栈中跨层使用，才有下面的逻辑
        // head->next此刻指向head后面的链表的尾节点
        // head->next->next = head把head节点放在了尾部
        head.next.next = head;  System.out.printf("将%d指向下一个节点%d \n" , head.next.val , head.val);
        head.next = null;   System.out.printf("将%d的下一个节点设置为 null \n" , head.val );

        System.out.println("这一轮递归函数执行完，得到的链表为：" + rHead );
        return rHead;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2 ,3 , 4};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode head2 = (new SolutionBack()).reverseList(head);
        System.out.println(head2);
    }
}

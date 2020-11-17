package com.cyf.list;
//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
// 示例：
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//
//
// 说明：
//
// 给定的 n 保证是有效的。
//
// 进阶：
//
// 你能尝试使用一趟扫描实现吗？
// Related Topics 链表 双指针

/**
 * @author by cyf
 * @date 2020/11/17.
 */
public class RemoveNthFromEnd {
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = result;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        //ListNode first = new ListNode(1, new ListNode(2));
        //ListNode first = new ListNode(1);
        ListNode node = removeNthFromEnd(first, 1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

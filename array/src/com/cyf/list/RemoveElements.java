package com.cyf.list;
//删除链表中等于给定值 val 的所有节点。
//
// 示例:
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
//
// Related Topics 链表

/**
 * @author by cyf
 * @date 2020/11/28.
 */
public class RemoveElements {

    public static ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(0, head);
        ListNode cur = pre;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(6,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(6,
                                                        new ListNode(5)))))));
//        ListNode head = new ListNode(1);
        ListNode node = removeElements(head, 6);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

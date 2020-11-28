package com.cyf.list;
//反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

/**
 * @author by cyf
 * @date 2020/11/28.
 */
public class ReverseList {
    /**
     * 反转链表 一次遍历 将当前节点的next指向前节点
     *
     * @param head /
     * @return 反转后链表
     */
    private static ListNode reverseList(ListNode head) {
        //前节点
        ListNode pre = null;
        //当前节点
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        //遍历到最后cur为null
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode node = reverseList(head);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

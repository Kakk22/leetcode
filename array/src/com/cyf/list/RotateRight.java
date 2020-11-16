package com.cyf.list;
//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
//
//

//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL
// Related Topics 链表 双指针

/**
 * @author by cyf
 * @date 2020/11/16.
 */
public class RotateRight {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode old = head;
        int n;
        for (n = 1; old.next != null; n++) {
            old = old.next;
        }
        //把最后一个节点指向头节点 形成闭环
        old.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < (n - k % n - 1); i++) {
            new_tail = new_tail.next;
        }
        ListNode new_head = new_tail.next;

        new_tail.next = null;
        return new_head;
    }

    public static ListNode towPoint(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;
        int n;
        ListNode cur = head;
        for (n = 0; cur != null; n++) {
            cur = cur.next;
        }
        ListNode fast = head;
        ListNode low = head;
        for (int i = 0; fast.next != null; i++) {
            if (i >= k % n) {
                low = low.next;
            }
            fast = fast.next;
        }

        fast.next = head;
        ListNode result = low.next;
        low.next = null;

        return result;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode node = towPoint(first, 1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

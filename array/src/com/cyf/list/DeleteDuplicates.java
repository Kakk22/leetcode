package com.cyf.list;
//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
// 示例 1:
//
// 输入: 1->1->2
//输出: 1->2
//
//
// 示例 2:
//
// 输入: 1->1->2->3->3
//输出: 1->2->3
// Related Topics 链表

/**
 * @author by cyf
 * @date 2020/11/18.
 */
public class DeleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode pre = new ListNode(0, head);
        ListNode slow = head;
        while (head != null) {
            if (slow.val != head.val) {
                slow.next = head;
                slow = head;
            }
            head = head.next;
            if (head == null){
                slow.next = null;
            }
        }
        return pre.next;
    }

    public static void main(String[] args) {
         //ListNode first = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(4)))))));
        ListNode first = new ListNode(1, new ListNode(1,new ListNode(2)));
        ListNode node = deleteDuplicates(first);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

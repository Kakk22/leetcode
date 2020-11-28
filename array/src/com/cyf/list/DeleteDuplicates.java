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

    /** 思路：快慢指针  慢指针指向当前节点 快指针每次循环往下走
     * 如果快慢指针的值不相等 则慢指针往下走 相当于只要中间有重复值 慢指针一直等到快指针走到不相等值时再指向快指针的值
     * @param head 头节点
     * @return 去重链表
     */
    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode pre = new ListNode(0, head);
        ListNode slow = head;
        while (head != null) {
            if (slow.val != head.val) {
                slow.next = head;
                slow = head;
            }
            head = head.next;
            if (head == null) {
                slow.next = null;
            }
        }
        return pre.next;
    }

    public static void main(String[] args) {
        //ListNode first = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(4)))))));
        ListNode first = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode node = deleteDuplicates(first);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

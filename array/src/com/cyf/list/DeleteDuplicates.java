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
        ListNode pre = new ListNode(0, head);
        int delVal = head.val;
        while (head != null) {
            if (head.next == null) {
                break;
            }
            if (delVal == head.next.val) {
                head.next = head.next.next;
            }
            if (head.next != null) {
                delVal = head.next.val;
            }
            if (head.next.next == null && head.next.val == head.val){
                head.next = null;
                break;
            }
            head = head.next;
        }
        return pre.next;
    }

    public static void main(String[] args) {
//        ListNode first = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4,new ListNode(4)))))));
        ListNode first = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode node = deleteDuplicates(first);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

package com.cyf.list;
//请判断一个链表是否为回文链表。
//
// 示例 1:
//
// 输入: 1->2
//输出: false
//
// 示例 2:
//
// 输入: 1->2->2->1
//输出: true
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 链表 双指针

/**
 * 回文链表
 *
 * @author by cyf
 * @date 2020/11/29.
 */
public class IsPalindrome {
    /**
     * 解题思路:
     * 1、先找到链表中点位置
     * 2、反转后半部分的链表
     * 3、一次遍历 前后两端的值是否相同
     *
     * @param head 头节点
     * @return 是否回文链表
     */
    private static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            //快指针一次走两步 慢指针一次走一步
            //结束后慢指针则为中点位置
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            //链表为单数
            slow = slow.next;
        }
        //反转后的后半截链表
        slow = reverseList(slow);
        //头节点开始比较
        fast = head;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    /**
     * 反转链表
     *
     * @param head \
     * @return 头节点
     */
    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            //储存下一个节点
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(isPalindrome(head));
    }
}

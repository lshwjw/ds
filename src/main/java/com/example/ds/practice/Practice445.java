package com.example.ds.practice;

import java.util.Stack;

/**
 * 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *  
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 */
public class Practice445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        ListNode sentry = new ListNode(-1);
        ListNode tmp1;
        ListNode tmp2;
        ListNode newNode;
        int sum;
        boolean flag = false;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            tmp1 = s1.pop();
            tmp2 = s2.pop();
            sum = flag ? tmp1.val + tmp2.val + 1 : tmp1.val + tmp2.val;
            flag = sum >= 10;
            newNode = new ListNode(sum % 10);
            newNode.next = sentry.next;
            sentry.next = newNode;
        }
        Stack<ListNode> left = s1.isEmpty() ? s2 : s1;
        ListNode leftTmp;
        while (!left.isEmpty()) {
            leftTmp = left.pop();
            sum = flag ? leftTmp.val + 1 : leftTmp.val;
            flag = sum >= 10;
            newNode = new ListNode(sum % 10);
            newNode.next = sentry.next;
            sentry.next = newNode;
        }
        if (flag) {
            newNode = new ListNode(1);
            newNode.next = sentry.next;
            sentry.next = newNode;
        }
        return sentry.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode sentry = new ListNode(-1);
        ListNode cur = sentry;
        int sum;
        boolean flag = false;
        while (l1 != null && l2 != null) {
            sum = flag ? l1.val + l2.val + 1 : l1.val + l2.val;
            flag = sum >= 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode left = l1 == null ? l2 : l1;
        while (left != null) {
            sum = flag ? left.val + 1 : left.val;
            flag = sum >= 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            left = left.next;
        }
        if (flag) {
            cur.next = new ListNode(1);
        }
        return reverseList(sentry.next);
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Practice445 practice = new Practice445();
        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(4);
//        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        ListNode result = practice.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + "\t");
            result = result.next;
        }
    }
}

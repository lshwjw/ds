package com.example.ds.practice;

/**
 25. K 个一组翻转链表
 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

 k 是一个正整数，它的值小于或等于链表的长度。

 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

 示例 :

 给定这个链表：1->2->3->4->5

 当 k = 2 时，应当返回: 2->1->4->3->5

 当 k = 3 时，应当返回: 3->2->1->4->5

 说明 :

 你的算法只能使用常数的额外空间。
 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Practice25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre.next = next;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private void print(ListNode head) {
        if(head == null) {
            return;
        }
        ListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val + "\t");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Practice25 practice = new Practice25();
        practice.print(head);
        ListNode result = practice.reverseKGroup(head, 5);
        practice.print(result);

    }
}

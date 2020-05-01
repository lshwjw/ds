package com.example.ds.practice;

/**
 * @Author: weijianwei
 * @Date: 2020-04-29 11:39
 * @Description: 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class Practice61 {

    /**
     * 超出时间限制
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            while (true) {
                ListNode next = cur.next;
                if (next == null) {
                    cur.next = head;
                    pre.next = null;
                    head = cur;
                    pre = cur;
                    break;
                } else {
                    pre = cur;
                    cur = next;
                }
            }
        }
        return head;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int count = k % len;
        ListNode pre = head;
        cur = head;
        for (int i = 0; i < count; i++) {
            while (true) {
                ListNode next = cur.next;
                if (next == null) {
                    cur.next = head;
                    pre.next = null;
                    head = cur;
                    pre = cur;
                    break;
                } else {
                    pre = cur;
                    cur = next;
                }
            }
        }
        return head;
    }

    public ListNode rotateRight3(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int count = k % len;
        if (count == 0) {
            return head;
        }
        ListNode pre = head;
        cur = head;
        int num = 0;
        while (true) {
            ListNode next = cur.next;
            if (len - num <= count) {
                if (len - num == 1) {
                    cur.next = head;
                    head = pre.next;
                    pre.next = null;
                    break;
                } else {
                    cur = next;
                }
            } else {
                pre = cur;
                cur = next;
            }
            num++;
        }
        return head;
    }

    public ListNode rotateRight4(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode cur = head;
        int len = 1;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }
        int count = k % len;
        if (count == 0) {
            return head;
        }
        cur.next = head;
        cur = head;
        for (int i = 0; i < len - count - 1; i++) {
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;
        return head;
    }

    public static void main(String[] args) {
        Practice61 practice = new Practice61();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        ListNode result = practice.rotateRight(head, 4);
//        ListNode result = practice.rotateRight2(head, 2000000000);
//        ListNode result = practice.rotateRight3(head, 0);
        ListNode result = practice.rotateRight4(head, 0);
        while (result != null) {
            System.out.print(result.val + "\t");
            result = result.next;
        }
    }
}

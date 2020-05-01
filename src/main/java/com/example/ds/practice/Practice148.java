package com.example.ds.practice;

/**
 * @Author: weijianwei
 * @Date: 2020-05-01 16:49
 * @Description: 148. 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class Practice148 {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        return head;
    }

    private ListNode sort(ListNode head, ListNode tail) {
        ListNode tag = tail;
        ListNode cur = head.next;
        ListNode pre = head;
        while (tag != head.next) {
            while (cur != tag) {
                if (cur.val < pre.val) {
                    int tmp = cur.val;
                    cur.val = pre.val;
                    pre.val = tmp;
                }
                pre = cur;
                cur = cur.next;
            }
            tag = pre;
            pre = head;
            cur = head.next;
        }
        return head;
    }

    public ListNode sortList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tag = null;
        ListNode cur = head.next;
        ListNode pre = head;
        while (tag != head.next) {
            while (cur != tag) {
                if (cur.val < pre.val) {
                    int tmp = cur.val;
                    cur.val = pre.val;
                    pre.val = tmp;
                }
                pre = cur;
                cur = cur.next;
            }
            tag = pre;
            pre = head;
            cur = head.next;
        }
        return head;
    }

    public ListNode sortList3(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tag = head;
        ListNode cur = tag.next;
        while (tag.next != null) {
            while (cur != null) {
                if (cur.val < tag.val) {
                    int tmp = cur.val;
                    cur.val = tag.val;
                    tag.val = tmp;
                }
                cur = cur.next;
            }
            tag = tag.next;
            cur = tag.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Practice148 practice = new Practice148();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode result = practice.sortList(head);
        while (result != null) {
            System.out.print(result.val + "\t");
            result = result.next;
        }
    }
}

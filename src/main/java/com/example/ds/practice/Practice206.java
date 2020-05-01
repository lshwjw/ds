package com.example.ds.practice;

/**
 * @Author: weijianwei
 * @Date: 2020-04-26 12:12
 * @Description: 206. 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Practice206 {

    public ListNode reverseList(ListNode head) {
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

    public ListNode reverseList2(ListNode head) {
        return reverse(null, head, null);
    }

    private ListNode reverse(ListNode pre, ListNode cur, ListNode next) {
        if (cur == null) {
            return pre;
        }
        next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;
        return reverse(pre, cur, next);
    }

    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static void main(String[] args) {
        Practice206 practice = new Practice206();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        ListNode result = practice.reverseList(head);
        ListNode result = practice.reverseList3(head);
        while (result != null) {
            System.out.print(result.val + "\t");
            result = result.next;
        }
    }
}

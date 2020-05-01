package com.example.ds.practice;

/**
 * @Author: weijianwei
 * @Date: 2020-04-28 11:34
 * @Description: 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Practice86 {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        // 最后一个小于x的节点
        ListNode tag = head;
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val < x) {
                if (tag == head && tag.val >= x) {
                    cur.next = tag;
                    head = cur;
                } else {
                    if (tag.next != cur) {
                        cur.next = tag.next;
                        tag.next = cur;
                    }
                }
                tag = cur;
                cur = next;
                if (pre != head) {
                    pre.next = cur;
                }
            } else {
                pre = cur;
                cur = next;
            }
        }
        return head;
    }

    public ListNode partition2(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;
    }

    public static void main(String[] args) {
        Practice86 practice = new Practice86();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);
        ListNode result = practice.partition(head, 7);
        while (result != null) {
            System.out.print(result.val + "\t");
            result = result.next;
        }
    }
}

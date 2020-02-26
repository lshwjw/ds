package com.example.ds.practice;

/**
 24. 两两交换链表中的节点
 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

  

 示例:

 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Practice24 {

    public ListNode swapPairs(ListNode head) {
        ListNode pre = head;
        ListNode cur = head;
        ListNode mark = new ListNode(-1);
        boolean swapFlag = false;
        boolean firstSwap = true;
        while (cur != null) {
            if (swapFlag) {
                ListNode tmp = cur.next;
                pre.next = tmp;
                cur.next = pre;
                mark.next = cur;
                mark = pre;
                swapFlag = false;
                if (firstSwap) {
                    head = cur;
                    firstSwap = false;
                }
                pre = tmp;
                cur = tmp;
            } else {
                cur = cur.next;
                swapFlag = true;
            }
        }
        return head;
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
        Practice24 practice = new Practice24();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);
//        l1.next.next.next.next.next = new ListNode(6);
        ListNode result = practice.swapPairs(l1);
        practice.print(result);
    }
}

package com.example.ds.practice;

/**
 * @Author: weijianwei
 * @Date: 2019-11-29 11:16
 * @Description: 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Practice2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return new ListNode(0);
        }
        boolean flag = false;
        ListNode head = null;
        ListNode current = null;
        int sum = 0;
        while (true) {
            if (l1 != null && l2 != null) {
                sum = flag ? l1.val + l2.val + 1 : l1.val + l2.val;
                if (current == null) {
                    head = new ListNode(sum % 10);
                    current = head;
                } else {
                    current.next = new ListNode(sum % 10);
                    current = current.next;
                }
                flag = sum >= 10 ? true : false;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                sum = flag ? l1.val + 1 : l1.val;
                current.next = new ListNode(sum % 10);
                current = current.next;
                flag = sum >= 10 ? true : false;
                l1 = l1.next;
            } else if (l1 == null && l2 != null) {
                sum = flag ? l2.val + 1 : l2.val;
                current.next = new ListNode(sum % 10);
                current = current.next;
                flag = sum >= 10 ? true : false;
                l2 = l2.next;
            } else {
                if (flag) {
                    sum = 1;
                    current.next = new ListNode(sum);
                }
                break;
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(1);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        Practice2 practice = new Practice2();
        ListNode result = practice.addTwoNumbers(l1, l2);
        ListNode current = result;
        while (current != null) {
            if (current == result) {
                System.out.print(current.val);
            } else {
                System.out.print(" -> " + current.val);
            }
            current = current.next;
        }
    }
}



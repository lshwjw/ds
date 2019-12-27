package com.example.ds.practice;

import java.util.Stack;

/**
 * @Author: weijianwei
 * @Date: 2019-12-27 20:40
 * @Description: 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class Practice19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        int size = stack.size();
        if (size == 1) {
            return null;
        }
        int index = 0;
        if (n == 1) {
            while (index < size) {
                ListNode pop = stack.pop();
                if (index == n) {
                    pop.next = null;
                    break;
                }
                index++;
            }
        } else if (n == size) {
            while (index < size) {
                ListNode pop = stack.pop();
                if (index == n - 2) {
                    head = pop;
                } else if (index == n - 1) {
                    pop.next = null;
                }
                index++;
            }
        } else {
            while (index < size) {
                ListNode pop = stack.pop();
                if (index == n - 2) {
                    tmp = pop;
                } else if (index == n - 1) {
                    pop.next = null;
                } else if (index == n) {
                    pop.next = tmp;
                    break;
                }
                index++;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void print(ListNode head) {
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
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        Practice19 practice = new Practice19();
        practice.print(head);
        ListNode result = practice.removeNthFromEnd(head, 1);
        System.out.println(result == null ? "" : result.val);
        practice.print(result);

    }
}

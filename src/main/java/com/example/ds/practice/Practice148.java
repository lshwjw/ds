package com.example.ds.practice;

/**
 * @Author: weijianwei
 * @Date: 2020-05-01 16:49
 * @Description: 148. 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3   2->4->1->3   1->2->3->4
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 3->5->1->4->0  3->5->1->4->0
 *
 */
public class Practice148 {

    /**
     * 归并排序（迭代）
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        int len = 1;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }
        ListNode sentry = new ListNode(-1);
        sentry.next = head;
        for (int i = 1; i < len; i *= 2) {
            ListNode tag = sentry;
            cur = sentry.next;
            while (cur != null) {
                ListNode left = cur;
                ListNode right = split(left, i);
                cur = split(right, i);
                tag.next = mergeTwoLists(left, right);
                while (tag.next != null) {
                    tag = tag.next;
                }
            }
        }
        return sentry.next;
    }

    /**
     * 切割链表为2个链表，返回后一个链表的头节点
     * @param head
     * @param step
     * @return
     */
    private ListNode split(ListNode head, int step) {
        if (head == null) {
            return head;
        }
        for (int i = 1; head.next != null && i < step; i++) {
            head = head.next;
        }
        ListNode next = head.next;
        head.next = null;
        return next;
    }

    /**
     * 归并排序（快慢双指针）
     * @param head
     * @return
     */
    public ListNode sortList0(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tag = slow.next;
        slow.next = null;
        ListNode l1 = sortList0(head);
        ListNode l2 = sortList0(tag);
        return mergeTwoLists(l1, l2);
    }

    /**
     * 快速排序（指针交换）
     * @param head
     * @return
     */
    public ListNode sortList1(ListNode head) {
        return quickSort(head);
    }

    public ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode before = new ListNode(0);
        ListNode beforeHead = before;
        ListNode after = new ListNode(0);
        ListNode afterHead = after;
        ListNode cur = head;
        int pivot = head.val;
        while (cur != null) {
            if (cur.val < pivot) {
                before.next = cur;
                before = before.next;
            } else {
                after.next = cur;
                after = after.next;
            }
            cur = cur.next;
        }
        before.next = afterHead.next;
        after.next = null;
        ListNode right = quickSort(head.next);
        head.next = null;
        ListNode left = quickSort(beforeHead.next);
        cur = left;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = right;
        return left;
    }

    /**
     * 快速排序（值交换）
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        quickSort(head, null);
        return head;
    }

    private void quickSort(ListNode head, ListNode tail) {
        if (head == tail || head.next == tail) {
            return;
        }
        int pivot = head.val;
        ListNode tag = head;
        ListNode cur = head.next;
        while (cur != tail) {
            if (cur.val < pivot) {
                tag = tag.next;
                int tmp = cur.val;
                cur.val = tag.val;
                tag.val = tmp;
            }
            cur = cur.next;
        }
        int tmp = head.val;
        head.val = tag.val;
        tag.val = tmp;
        quickSort(head, tag);
        quickSort(tag.next, tail);
    }

    /**
     * 归并排序
     * @param head
     * @return
     */
    public ListNode sortList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        int len = 1;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }
        ListNode tail = cur;
        return mergeSort(head, tail, len);
    }

    private ListNode mergeSort(ListNode head, ListNode tail, int len) {
        if (head == tail) {
            return head;
        }
        boolean flag = len % 2 == 0;
        ListNode cur = head;
        len = len / 2;
        int step = flag ? len : len + 1;
        for (int i = 1; cur.next != null && i < step; i++) {
            cur = cur.next;
        }
        ListNode next = cur.next;
        cur.next = null;
        ListNode l1 = mergeSort(head, cur, step);
        ListNode l2 = mergeSort(next, tail, len);
        return mergeTwoLists(l1, l2);
    }

    public ListNode sortList4(ListNode head) {
        if (head == null) {
            return null;
        }
        return sort(head);
    }

    private ListNode sort(ListNode cur) {
        if (cur.next == null) {
            return cur;
        }
        ListNode p = sort(cur.next);
        cur.next = null;
        return mergeTwoLists(cur, p);
    }

    /**
     * 合并2个有序链表
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == l2) {
            return l1;
        }
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    public ListNode sortList5(ListNode head) {
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

    public ListNode sortList6(ListNode head) {
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
        head.next.next.next.next = new ListNode(0);
//        head.next.next.next.next.next = new ListNode(2);
        ListNode result = practice.sortList6(head);
        while (result != null) {
            System.out.print(result.val + "\t");
            result = result.next;
        }
    }
}

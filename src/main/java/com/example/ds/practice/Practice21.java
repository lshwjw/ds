package com.example.ds.practice;

/**
 21. 合并两个有序链表
 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 */
public class Practice21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head = null;
        ListNode result = null;
        while (true) {
            if (l1 == null) {
                while (l2 != null) {
                    if (result == null) {
                        result = new ListNode(l2.val);
                        head = result;
                    } else {
                        result.next = new ListNode(l2.val);
                        result = result.next;
                    }
                    l2 = l2.next;
                }
                return head;
            }
            if (l2 == null) {
                while (l1 != null) {
                    if (result == null) {
                        result = new ListNode(l1.val);
                        head = result;
                    } else {
                        result.next = new ListNode(l1.val);
                        result = result.next;
                    }
                    l1 = l1.next;
                }
                return head;
            }
            if (l1.val < l2.val) {
                if (result == null) {
                    result = new ListNode(l1.val);
                    head = result;
                } else {
                    result.next = new ListNode(l1.val);
                    result = result.next;
                }
                l1 = l1.next;
            } else {
                if (result == null) {
                    result = new ListNode(l2.val);
                    head = result;
                } else {
                    result.next = new ListNode(l2.val);
                    result = result.next;
                }
                l2 = l2.next;
            }
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head = null;
        ListNode result = null;
        while (true) {
            if (l1 == null) {
                if (result == null) {
                    result = l2;
                    head = result;
                } else {
                    result.next = l2;
                }
                return head;
            }
            if (l2 == null) {
                if (result == null) {
                    result = l1;
                    head = result;
                } else {
                    result.next = l1;
                }
                return head;
            }
            if (l1.val < l2.val) {
                if (result == null) {
                    result = new ListNode(l1.val);
                    head = result;
                } else {
                    result.next = new ListNode(l1.val);
                    result = result.next;
                }
                l1 = l1.next;
            } else {
                if (result == null) {
                    result = new ListNode(l2.val);
                    head = result;
                } else {
                    result.next = new ListNode(l2.val);
                    result = result.next;
                }
                l2 = l2.next;
            }
        }
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode result = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (result == null) {
                    result = l1;
                    head = result;
                } else {
                    result.next = l1;
                    result = result.next;
                }
                l1 = l1.next;
            } else {
                if (result == null) {
                    result = l2;
                    head = result;
                } else {
                    result.next = l2;
                    result = result.next;
                }
                l2 = l2.next;
            }
        }
        result.next = l1 == null ? l2 : l1;
        return head;
    }

    public ListNode mergeTwoLists4(ListNode l1, ListNode l2) {
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

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Practice21 practice = new Practice21();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        practice.print(practice.mergeTwoLists3(l1, l2));
    }
}

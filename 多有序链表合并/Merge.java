public class Merge {
    public static void main(String[] args) {

    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode();
        ListNode cur = head;
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                ListNode tmp = new ListNode(list1.val);
                cur.next = tmp;
                cur = tmp;
                list1 = list1.next;
            } else {
                ListNode tmp = new ListNode(list2.val);
                cur.next = tmp;
                cur = tmp;
                list2 = list2.next;
            }

        }
        while (list1 != null) {
            ListNode tmp = new ListNode(list1.val);
            cur.next = tmp;
            cur = tmp;
            list1 = list1.next;
        }
        while (list2 != null) {
            ListNode tmp = new ListNode(list2.val);
            cur.next = tmp;
            cur = tmp;
            list2 = list2.next;
        }

        return head.next;

    }

    ListNode merge(ListNode[] lists, int s, int e) {
        if ((e - s) == 1) {
            return lists[s];
        }
        int mid = (e - s) / 2;
        ListNode ans1 = merge(lists, s, mid);
        ListNode ans2 = merge(lists, mid, e);
        ListNode ans3 = mergeTwoLists(ans1, ans2);

        return ans3;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        if (len == 1) {
            return lists[0];
        }
        int l = 0;
        int mid = l / 2;
        ListNode ans1 = merge(lists, l, mid);
        ListNode ans2 = merge(lists, mid, l);

        ListNode ans3 = mergeTwoLists(ans1, ans2);

        return ans3;
    }
}
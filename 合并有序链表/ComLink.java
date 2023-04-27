public class ComLink {
    public static void main(String[] args) {

    }
}

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
}
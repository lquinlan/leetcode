public class CycleLink {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        for (int i = 0; i < 10001; ++i) {
            if (head == null) {
                return true;
            }
            head = head.next;
        }
        return false;

    }
}

class ListNode {
    int value;
    ListNode next;

    ListNode(int val) {
        this.value = val;
        next = null;
    }
}
class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        if (slow == null || fast == null) {
            return null;
        }
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        // if(slow==fast){
        // System.out.println(slow.val);
        // }
        slow = slow.next;
        // System.out.println("a");
        ListNode ans = head;
        while (ans != slow) {
            ans = ans.next;
            slow = slow.next;
        }
        return ans;

    }
}

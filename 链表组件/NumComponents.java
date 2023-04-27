import java.util.HashSet;

public class NumComponents {
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
    public int numComponents(ListNode head, int[] nums) {
        int cnt = 0;
        if (nums.length == 1) {
            return 1;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            set.add(i);
        }
        boolean f = false;

        while (head != null) {
            if (set.contains(head.val)) {

                set.remove(head.val);
                f = true;
            } else {
                if (f) {
                    ++cnt;

                }

                f = false;
            }
            head = head.next;
        }
        if (f) {
            ++cnt;
        }

        return cnt;

    }
}
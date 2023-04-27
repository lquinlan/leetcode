import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode prev = head;
        List<Integer> array = new ArrayList<Integer>();
        while (prev != null) {
            array.add(prev.val);
            prev = prev.next;

        }
        prev = head;

        head = head.next;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;

        }
        int i = 0;
        while (prev != null) {
            if (prev.val != array.get(i++)) {
                return false;
            }
        }
        // return prev;
        return true;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode() {
    }
}
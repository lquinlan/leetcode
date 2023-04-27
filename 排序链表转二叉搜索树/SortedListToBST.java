import java.util.ArrayList;
import java.util.List;

public class SortedListToBST {
    public static void main(String[] args) {

    }
}

// Definition for singly-linked list.
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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

class Solution {
    List<Integer> tmp = new ArrayList<Integer>();

    void creatnode(TreeNode last, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(tmp.get(mid));
        if (root.val < last.val) {
            last.left = root;
        } else {
            last.right = root;
        }
        creatnode(root, l, mid);
        creatnode(root, mid + 1, r);

    }

    public TreeNode sortedListToBST(ListNode head) {

        while (head != null) {
            tmp.add(head.val);
            head = head.next;
        }
        int len = tmp.size();
        TreeNode root = new TreeNode(tmp.get(len / 2));
        creatnode(root, 0, len / 2);
        creatnode(root, len / 2 + 1, len);
        return root;

    }

}
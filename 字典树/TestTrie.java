public class TestTrie {
    public static void main(String[] args) {

    }
}

class Trie {

    TreeNode head = new TreeNode();

    public Trie() {

    }

    public void insert(String word) {
        TreeNode cur = head;
        for (var i : word.toCharArray()) {
            int ind = i - 'a';
            if (cur.children[ind] == null) {
                cur.children[ind] = new TreeNode();
            }
            cur = cur.children[ind];

        }
        cur.isEnd = true;

    }

    public boolean search(String word) {
        TreeNode cur = head;
        for (var i : word.toCharArray()) {
            int ind = i - 'a';
            if (cur.children[ind] == null) {
                return false;
            }
            cur = cur.children[ind];

        }
        return cur.isEnd;

    }

    public boolean startsWith(String prefix) {
        TreeNode cur = head;
        for (var i : prefix.toCharArray()) {
            int ind = i - 'a';
            if (cur.children[ind] == null) {
                return false;
            }
            cur = cur.children[ind];

        }
        return true;

    }
}

class TreeNode {
    TreeNode[] children = new TreeNode[26];
    boolean isEnd;

}
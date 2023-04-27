import java.util.ArrayList;
import java.util.List;

public class PostOrder {
    public static void main(String[] args) {

    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    List<Integer> ans;

    Solution() {
        ans = new ArrayList<Integer>();
    }

    void dfs(Node root) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < root.children.size(); ++i) {
            dfs(root.children.get(i));
        }
        ans.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        dfs(root);

        return ans;

    }
}
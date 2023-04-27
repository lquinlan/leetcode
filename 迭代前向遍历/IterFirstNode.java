import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterFirstNode {
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
    List<Integer> answer;

    Solution() {
        answer = new ArrayList<Integer>();
    }

    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<Node>();
        while (root != null) {
            answer.add(root.val);
            if (root.children.size() != 0) {
                for (int i = root.children.size() - 1; i > 0; --i) {
                    stack.push(root.children.get(i));
                }
                //
                root = root.children.get(0);
            } else if (!stack.empty()) {
                root = stack.pop();
            } else {
                root = null;
            }

        }

        return answer;

    }
}
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
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
    public List<List<Integer>> levelOrder(Node root) {
        // if(root==null){
        // return null;
        // }
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        if (root == null) {
            return answer;
        }
        Deque<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<Integer>();
            int n = queue.size();
            for (int i = 0; i < n; ++i) {
                Node child = queue.poll();
                tmp.add(child.val);
                for (var ch : child.children) {
                    queue.add(ch);
                }

            }
            answer.add(tmp);

        }

        return answer;

    }
}
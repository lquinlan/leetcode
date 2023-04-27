import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        
    }
}


// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class Solution {
    Node[] vis=new Node[105];
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }
        if(vis[node.val]!=null){
            return vis[node.val];
        }
        Node clone=new Node(node.val,new ArrayList < Node >());
        vis[clone.val]=clone;
        for(var i:node.neighbors){
            clone.neighbors.add(cloneGraph(i));

        }
        return node;
        
    }
}
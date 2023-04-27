import java.util.HashMap;

public class Main{
    public static void main(String[] args) {
        
    }
}
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {
    HashMap<Node,Node > map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        if(!map.containsKey(head)){
            Node newNode=new Node(head.val);
            newNode.next = copyRandomList(head.next);
            newNode.random=copyRandomList(head.random);
        }
        return map.get(head);
        

        
    }
}
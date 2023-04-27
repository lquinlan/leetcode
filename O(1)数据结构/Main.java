import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AllOne al = new AllOne();
        al.inc("hell");
        // al.inc("he");
        al.inc("hell");
        al.inc("he");
        Node root = al.Head.next;
        System.out.println(root.count);
        System.out.println(root.lists.toString());
        root = al.Head.prev;
        System.out.println(root.count);
        System.out.println(root.lists.toString());

    }
}

class AllOne {
    HashMap<String, Node> map = new HashMap<String, Node>();
    Node Head;

    public AllOne() {
        Head = new Node();
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node tmp = map.get(key);
            Node tt = tmp.insert(key);
            map.put(key, tt);
        } else {
            if (Head.prev == Head.next && Head.prev == Head) {

                Node tmp = new Node(key, Head, Head, 1);
                Head.prev = tmp;
                Head.next = tmp;
                map.put(key, tmp);

            } else {
                if (Head.next.count == 1) {
                    Head.next.lists.add(key);
                    map.put(key, Head.next);
                } else {
                    Node tmp = Head.insert(key);
                    map.put(key, tmp);
                }
            }

        }

    }

    public void dec(String key) {
        Node tmp = map.get(key);
        Node tt = tmp.remove(key);
        if (tt == null) {
            map.remove(key);
        } else {
            map.put(key, tt);
        }

    }

    public String getMaxKey() {
        int s = Head.prev.lists.size();
        if (s == 0) {
            return null;
        } else {
            return Head.prev.lists.get(0);
        }

    }

    public String getMinKey() {
        int s = Head.next.lists.size();
        if (s == 0) {
            return null;
        } else {
            return Head.next.lists.get(0);
        }
    }
}

class Node {
    List<String> lists = new LinkedList<String>();
    Node prev = null;
    Node next = null;
    int count = 0;

    Node() {
        prev = this;
        next = this;
        count = 0;
        lists.add("");

    }

    Node(String key, Node prev, Node next, int count) {
        lists.add(key);
        this.prev = prev;
        this.next = next;
        this.count = count;
    }

    Node insert(String key) {
        // if()
        lists.remove(key);
        Node tmp;
        if (this.next != null && this.next.count == count + 1) {
            this.next.lists.add(key);
            tmp = this.next;
        } else {
            tmp = new Node(key, this, this.next, count + 1);
            this.next.prev = tmp;
            this.next = tmp;

            // return tmp;
        }
        if (lists.size() == 0) {
            this.prev.next = this.next;
            this.next.prev = this.prev;
            this.prev = null;
            this.next = null;
        }
        return tmp;

    }

    Node remove(String key) {

        lists.remove(key);
        Node tmp;
        if (this.count == 1) {
            tmp = null;
        }
        if (this.prev != null && this.prev.count == count - 1) {
            this.prev.lists.add(key);
            tmp = this.prev;

        } else {
            tmp = new Node(key, this.prev, this, count - 1);
            this.prev.next = tmp;
            this.prev = tmp;

            // return tmp;
        }
        if (lists.size() == 0) {
            this.prev.next = this.next;
            this.next.prev = this.prev;
            this.prev = null;
            this.next = null;
        }
        return tmp;

    }
}
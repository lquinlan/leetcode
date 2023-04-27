// import java.util.HashMap;

public class LRU {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        System.out.println(lruCache.Head.next.val);
        System.out.println(lruCache.Head.prev.val);
        lruCache.put(2, 2);
        lruCache.get(1);
        System.out.println("dsds=" + lruCache.Head.next.val);
        System.out.println(lruCache.Head.prev.val);
        // System.out.println(lruCache.get(2));
        lruCache.put(3, 3);
        System.out.println(lruCache.Head.prev.val);
        System.out.println(lruCache.get(2));

    }
}

class LRUCache {

    int capacity;
    Node Head;
    int curcap;
    Node map[] = new Node[10002];

    public LRUCache(int capacity) {
        this.capacity = capacity;
        Head = new Node();
        curcap = 0;
    }

    public int get(int key) {
        if (map[key] != null) {
            Node tmp = map[key];
            tmp.remove();
            Head.prev.insert(tmp);
            return tmp.val;
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {
        if (map[key] != null) {
            // map.remove(key);
            Node tmp = map[key];
            tmp.val = value;
            tmp.remove();
            Head.prev.insert(tmp);
        } else {
            if (curcap >= capacity) {
                int t = Head.next.key;
                Head.next.remove();
                map[t] = null;
                // System.out.println("t=" + t);
                curcap--;
            }
            Node tmp = new Node(value, key);
            map[key] = tmp;
            Head.prev.insert(tmp);
            curcap++;
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class Node {
    // List<String> lists = new LinkedList<String>();
    Node prev = null;
    Node next = null;
    // int lastTime = 0;
    int key;
    int val;

    Node() {
        prev = this;
        next = this;
        // lastTime = 0;
        val = -99999;
        // lists.add("");
        key = -9999;

    }

    Node(int val, int key) {
        // lists.add(key);
        this.val = val;
        this.key = key;
        // this.prev = prev;
        // this.next = next;
        // this.lastTime = count;
    }

    void insert(Node tmp) {
        // if()
        // lists.remove(key);
        // Node tmp;
        tmp.next = this.next;
        tmp.prev = this;
        this.next.prev = tmp;
        this.next = tmp;

        // return tmp;
    }

    void remove() {

        this.prev.next = this.next;
        this.next.prev = this.prev;
        this.prev = null;
        this.next = null;

        // return tmp;

    }
}
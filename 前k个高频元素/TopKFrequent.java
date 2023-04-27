import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TopKFrequent {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ans = new int[] { 1, 1, 2 };
        s.topKFrequent(ans, 1);

    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        AllOne cap = new AllOne();
        for (var i : nums) {
            System.out.println(i);
            cap.inc(i);
        }
        System.out.println(cap.Head.next.lists.toString());
        System.out.println("j");
        return cap.getMaxKey(k);

    }
}

class AllOne {
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node Head;

    public AllOne() {
        Head = new Node();
    }

    public void inc(int key) {
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

    public void dec(int key) {
        Node tmp = map.get(key);
        Node tt = tmp.remove(Integer.valueOf(key));
        if (tt == null) {
            map.remove(key);
        } else {
            map.put(key, tt);
        }

    }

    public int[] getMaxKey(int k) {
        int[] ans = new int[k];
        int i = 0;
        Node head = Head;
        while (k != 0) {
            int s = head.prev.lists.size();
            if (s != 0) {
                if (k >= s) {
                    k -= s;
                    for (var j : head.prev.lists) {
                        ans[i++] = j;

                    }

                } else {
                    for (int j = 0; j < k; ++j) {
                        ans[i++] = head.prev.lists.get(j);
                    }
                    k = 0;
                }

            }
            head = head.prev;

        }
        return ans;

    }

}

class Node {
    List<Integer> lists = new LinkedList<Integer>();
    Node prev = null;
    Node next = null;
    int count = 0;

    Node() {
        prev = this;
        next = this;
        count = 0;
        lists.add(Integer.MIN_VALUE);

    }

    Node(int key, Node prev, Node next, int count) {
        lists.add(key);
        this.prev = prev;
        this.next = next;
        this.count = count;
    }

    Node insert(int key) {
        // if()
        lists.remove(Integer.valueOf(key));
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

    Node remove(int key) {

        lists.remove(Integer.valueOf(key));
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
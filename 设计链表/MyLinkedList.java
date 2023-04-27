public class MyLinkedList {
    class Node {
        Node next;
        Node prev;
        int val;

        Node() {
            next = null;
            prev = null;
            val = 0;
        }
    }

    Node Head;
    Node Last;
    int len;

    public MyLinkedList() {
        Head = new Node();
        Last = new Node();
        Head.next = Last;
        Last.prev = Head;
        len = -1;

    }

    public int get(int index) {

        if (index < 0 || index > len) {
            return -1;
        }
        Node tmp = Head;
        while (index >= 0) {
            tmp = tmp.next;
            --index;

        }
        return tmp.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node();
        newNode.val = val;
        newNode.next = Head.next;
        newNode.prev = Head;
        Head.next.prev = newNode;
        Head.next = newNode;
        ++len;

    }

    public void addAtTail(int val) {
        Node newNode = new Node();
        newNode.val = val;
        newNode.next = Last;
        newNode.prev = Last.prev;
        Last.prev.next = newNode;
        Last.prev = newNode;
        ++len;

    }

    public void addAtIndex(int index, int val) {
        if (index == (len + 1)) {
            addAtTail(val);

            return;
        }
        if (index <= 0) {
            addAtHead(val);

            return;
        }
        if (index > (len + 1)) {
            return;
        }
        Node tmp = Head;
        while (index >= 0) {
            tmp = tmp.next;
            --index;

        }
        Node newNode = new Node();
        newNode.val = val;
        newNode.next = tmp;
        newNode.prev = tmp.prev;
        tmp.prev.next = newNode;
        tmp.prev = newNode;
        ++len;
    }

    public void deleteAtIndex(int index) {
        if (index >= 0 && index <= len) {
            Node tmp = Head;
            while (index >= 0) {
                tmp = tmp.next;
                --index;

            }
            tmp.prev.next = tmp.next;
            tmp.next.prev = tmp.prev;
            tmp.next = null;
            tmp.prev = null;
            --len;

        }

    }
}
// 5
// 5 2
// 2
// 6 5 2
// 6 5 2 2
// 2
// 6 5 2 2 1
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
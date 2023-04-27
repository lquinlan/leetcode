import java.util.HashMap;

public class Main{
    public static void main(String[] args) {
        
    }
}


// class LRUCache {
//     DLinkList list=new DLinkList();
//     HashMap<Integer,ListNode> map=new HashMap<Integer,ListNode>();
//     int capacity;
//     int curcap;


//     public LRUCache(int capacity) {
//         this.capacity=capacity;
//         curcap=0;

//     }
    
//     public int get(int key) {
//         if(map.containsKey(key)){
//             ListNode tmp=map.get(key);
//             list.Insert(list.Head,  list.Del(tmp));
//             return tmp.getValue();    
//         }else{
//             return -1;
//         }


//     }
    
//     public void put(int key, int value) {
//         if(map.containsKey(key)){
//             ListNode tmp=map.get(key);
//             tmp.setValue(value);
//             list.Insert(list.Head,  list.Del(tmp));
//             return ;
//         }
//         while(curcap>=capacity){
//             map.remove(list.Del(list.Head.pre).getKey());
//             --curcap;
            
//         }
//         ListNode tmp=new ListNode(value,key);
//         list.Insert(list.Head, tmp);
//         map.put(key, tmp);
//         ++curcap;

//     }
// }

// /**
//  * Your LRUCache object will be instantiated and called as such:
//  * LRUCache obj = new LRUCache(capacity);
//  * int param_1 = obj.get(key);
//  * obj.put(key,value);
//  */

//  class ListNode{
//     ListNode pre;
//     ListNode next;
//     int key;
//     int value;



//     public int getKey() {
//         return key;
//     }



//     public void setKey(int key) {
//         this.key = key;
//     }



//     ListNode(int value,int key){
//         this.value=value;
//         this.key=key;
//         pre=null;
//         next=null;
//     }



//     public int getValue() {
//         return value;
//     }



//     public void setValue(int value) {
//         this.value = value;
//     }
// }

// class DLinkList{
//     ListNode Head;

//     DLinkList(){
//         Head=new ListNode(-1,-1);
//         Head.next=Head;
//         Head.pre=Head;
//     }

//     void Insert(ListNode ind,ListNode tmp){
//         tmp.next=ind.next;
//         tmp.next.pre=tmp;
//         ind.next=tmp;
//         tmp.pre=ind;
//     }

//     ListNode Del(ListNode cur){
//         cur.pre.next=cur.next;
//         cur.next.pre=cur.pre;
//         cur.next=null;
//         cur.pre=null;
//         return cur;
//     }
// }

class LRUCache {
    DLinkList list=new DLinkList();
    // HashMap<Integer,ListNode> map=new HashMap<Integer,ListNode>();
    ListNode[] map=new ListNode[10005];
    int capacity;
    int curcap;


    public LRUCache(int capacity) {
        this.capacity=capacity;
        curcap=0;
        // Arrays.fill

    }
    
    public int get(int key) {
        if(map[key]!=null){
            ListNode tmp=map[key];
            list.Insert(list.Head,  list.Del(tmp));
            return tmp.getValue();    
        }else{
            return -1;
        }


    }
    
    public void put(int key, int value) {
        if(map[key]!=null){
            ListNode tmp=map[key];
            tmp.setValue(value);
            list.Insert(list.Head,  list.Del(tmp));
            return ;
        }
        while(curcap>=capacity){
            map[list.Del(list.Head.pre).getKey()]=null;
            --curcap;
            
        }
        ListNode tmp=new ListNode(value,key);
        list.Insert(list.Head, tmp);
        map[key]= tmp;
        ++curcap;

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

 class ListNode{
    ListNode pre;
    ListNode next;
    int key;
    int value;



    public int getKey() {
        return key;
    }



    public void setKey(int key) {
        this.key = key;
    }



    ListNode(int value,int key){
        this.value=value;
        this.key=key;
        pre=null;
        next=null;
    }



    public int getValue() {
        return value;
    }



    public void setValue(int value) {
        this.value = value;
    }
}

class DLinkList{
    ListNode Head;

    DLinkList(){
        Head=new ListNode(-1,-1);
        Head.next=Head;
        Head.pre=Head;
    }

    void Insert(ListNode ind,ListNode tmp){
        tmp.next=ind.next;
        tmp.next.pre=tmp;
        ind.next=tmp;
        tmp.pre=ind;
    }

    ListNode Del(ListNode cur){
        cur.pre.next=cur.next;
        cur.next.pre=cur.pre;
        cur.next=null;
        cur.pre=null;
        return cur;
    }
}
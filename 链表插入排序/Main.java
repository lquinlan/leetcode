public class Main{
    public static void main(String[] args) {
        
    }
}
// /
//   Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
//  /
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = head;
        ListNode unsort=head.next;
        newHead.next=null;
        ListNode lastsort=head;
        while(unsort!=null) {
            if(lastsort.val<=unsort.val){
               ListNode insert=unsort;
                unsort=unsort.next;
                insert.next=null;
                // insert.next=tmp;
                lastsort.next=insert;
                lastsort=lastsort.next;

            }else{
                ListNode insert=unsort;
                unsort=unsort.next;
                insert.next=null;
                ListNode tmp=newHead;
                ListNode last=null;
                while(tmp!=null&&tmp.val<=insert.val){
                    last=tmp;
                    tmp=tmp.next;
                   
                }
                if(last==null) {
                    insert.next=tmp;
                    newHead=insert;
                }else{
                    insert.next=tmp;
                    last.next=insert;
                }

            }
           
        }
        return newHead;

    }
}
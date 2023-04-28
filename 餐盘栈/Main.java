import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Main{
    public static void main(String[] args) {
        DinnerPlates dPlates=new DinnerPlates(2);
        dPlates.push(1);
        dPlates.push(1);
        // dPlates.push(1);
        dPlates.push(1);
        dPlates.push(1);
        dPlates.push(1);
        dPlates.pop();
        
    }
}

// class DinnerPlates {
//     int curind;
//     int capacity;
//     // PriorityQueue<MyStack> nofull= new PriorityQueue<>((a,b)->a.index-b.index);
//     TreeSet<MyStack> notfull=new TreeSet<>((a,b)->a.index-b.index);
//     TreeSet<MyStack> notempty=new TreeSet<>((a,b)->b.index-a.index);
//     HashMap<Integer,MyStack> map=new HashMap<>();

    

//     public DinnerPlates(int capacity) {
//         this.capacity=capacity;
//         curind=0;
//         // notfull.isEmpty()

//     }
//     public MyStack getNewMyStack(){
//         return new MyStack(capacity, curind++);

//     }
//     public void push(int val) {
//         if(notfull.isEmpty()){
//             MyStack tmp=getNewMyStack();
//             // System.out.println(tmp.ind);
//             // System.out.println(tmp.MyStack.length);
//             tmp.push(val);
//             if(tmp.curcap!=capacity){
//                 notfull.add(tmp);
//             }
//             if(tmp.curcap==1){
//                 notempty.add(tmp);
//             }
//             map.put(tmp.index,tmp);
//         }else{
//             MyStack tmp=notfull.first();
//             tmp.push(val);
//             if(tmp.curcap==capacity){
//                 notfull.remove(tmp);
//             }
//             if(tmp.curcap==1){
//                 notempty.add(tmp);
//             }
//         }

//     }
    
//     public int pop() {
//         if(notempty.isEmpty()){
//             return -1;
//         }else{
//             MyStack tmp=notempty.first();
//             int ans=tmp.pop();
//             if(tmp.curcap==0){
//                 notempty.remove(tmp);
//             }
//             if(tmp.curcap==capacity-1){
//                 notfull.add(tmp);
//             }
//             return ans;
//         }

//     }
    
//     public int popAtStack(int index) {
//         if(map.containsKey(index)){
//             MyStack tmp=map.get(index);
//             if(tmp.curcap==0){
//                 return -1;
//             }else{
//                 int ans=tmp.pop();
//                 if(tmp.curcap==0){
//                     notempty.remove(tmp);
//                 }
//                 if(tmp.curcap==capacity-1){
//                     notfull.add(tmp);
//                 }
//                 return ans;

//             }

//         }else{
//             return -1;
//         }

//     }
// }

// /**
//  * Your DinnerPlates object will be instantiated and called as such:
//  * DinnerPlates obj = new DinnerPlates(capacity);
//  * obj.push(val);
//  * int param_2 = obj.pop();
//  * int param_3 = obj.popAtMyStack(index);
//  */
// class MyStack{
//     final static int Inf=200001;
//     // int capacity;
//     int[] MyStack;
//     int index;
//     int curcap;
//     int ind;
//     // int key;
//     MyStack(int cap,int ind){
//         MyStack=new int[cap];
//         index=ind;
//         curcap=0;
//         this.ind=cap;
//         // Null=Inf;
//     }
//     int pop(){
//         if(curcap==0){
//             return -1;
//         }else{
//             int ans=MyStack[ind];
//             ++ind;
           
//             --curcap;
//             return ans; 
//         }
//     }
//     void push(int val){
  
//         ++curcap;
//         MyStack[--ind]=val;
//     }
// }

class DinnerPlates {

   
    int step = 0;
    List<Integer> list = new ArrayList<>();
    int size = 0;
    List<Integer> removeList = new ArrayList<>();
    public DinnerPlates(int capacity) {
        step = capacity;
    }

    public void push(int val) {
        for (int i = 0; i < removeList.size(); i++) {
            if (removeList.get(i) >= list.size()) {
                 removeList.remove(i);
                   i--;
                continue;
            }
            if (list.get(removeList.get(i)) == 0) {
                list.set(removeList.get(i), val);
                removeList.remove(i);
                return;
            }
        }
        size++;
        list.add(val);
   }

    public int pop() {
        for (int i = size-1; i>=0; i--) {
            if (list.get(i) == 0) {
                list.remove(i);
                size--;
            } else {
                size--;
                return   list.remove(list.size() - 1);
            } 
            
        }
        return -1;
    }

    public int popAtStack(int index) {
        int end = (index + 1) * step ;
        if (size<=(end - step)) {
            return -1;
        }
        if (size <= end ) {
            return pop();
        }
        int val = -1;
        for (int i = end - 1; i >=end-step ; i--) {
            if (list.get(i) != 0) {
                val = list.get(i);
                list.set(i, 0);
                removeList.add(i);
                break;
            }
        }
        return val;
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
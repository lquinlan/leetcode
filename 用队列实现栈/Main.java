import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

    }
}

class MyStack {
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();
    int peek;

    public MyStack() {
        peek = -1;
    }

    public void push(int x) {
        if (queue1.isEmpty()) {
            queue2.add(x);
            peek = x;
        } else {
            queue1.add(x);
            peek = x;
        }

    }

    public int pop() {
        if(!empty()){
            if (queue1.isEmpty()){
                if (queue2.size()==1){
                    peek = -1;
                    return queue2.poll();
                }
                while(queue2.size()>1){
                    if(queue2.size()==2){
                        peek = queue2.peek();
                    }
                    queue1.add(queue2.poll());
                }
                return queue2.poll();
            }else{
                if (queue1.size()==1){
                    peek = -1;
                    return queue1.poll();
                }
                while(queue1.size()>1){
                    if(queue1.size()==2){
                        peek = queue1.peek();
                    }
                    queue2.add(queue1.poll());
                }
                return queue1.poll();
            }

        }
        return -1;
        


    }

    public int top() {
        if(!empty()){
            return peek;
        }
        return -1;

    }

    public boolean empty() {
        return queue1.isEmpty()&&queue2.isEmpty();

    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
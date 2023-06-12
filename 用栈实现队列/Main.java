import java.util.Stack;

public class Main {

}

class MyQueue {
    Stack<Integer> q1 = new Stack<Integer>();
    Stack<Integer> q2 = new Stack<Integer>();
    // int peek;

    public MyQueue() {

    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        if(!q2.isEmpty()){
            return q2.pop();
        }else{
            while(!q1.isEmpty()){
                q2.add(q1.pop());
            }
        }
        return q2.pop();

    }

    public int peek() {
        if(!q2.isEmpty()){
            return q2.peek();
        }else{
            while(!q1.isEmpty()){
                q2.add(q1.pop());
            }
        }
        return q2.peek();

    }

    public boolean empty() {
        return q1.isEmpty()&&q2.isEmpty();

    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
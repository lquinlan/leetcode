// import java.util.PriorityQueue;

// import java.util.LinkedList;
// import java.util.List;


// 普通方法模拟
// class Solution {
//     public int mctFromLeafValues(int[] arr) {
//         if (arr.length == 1) {
//             return arr[0];
//         }
//         if (arr.length == 2) {
//             return arr[0] * arr[1];
//         }
//         List<node> queue = new LinkedList<node>();
//         for (var i : arr) {
//             queue.add(new node(i, i));
//         }
//         // queue.add(new node(Integer.MAX_VALUE, 2333));
//         int ans = 0;
//         while (queue.size() > 1) {
//             int tmp = Integer.MAX_VALUE;
//             int l = 0;
//             int r = 0;
//             for (int i = 0; i < queue.size() - 1; i++) {
//                 if(queue.get(i).max*queue.get(i+1).max<tmp){
//                     tmp=queue.get(i).max*queue.get(i+1).max;
//                     l=i;
//                     r=i+1;
//                 }
//             }
//             // System.out.println("tmp=="+tmp);
//             ans+=tmp;
//             queue.add(r+1, new node(tmp,Math.max(queue.get(r).max,queue.get(l).max)));
//             queue.remove(r);
//             queue.remove(l);
//         }
//         return ans;

//     }

//     class node {
//         int val;
//         int max;

//         node(int val, int max) {
//             this.val = val;
//             this.max = max;
//         }
//     }
// }
// 
// 单调栈
import java.util.Stack;

class Solution {
    public int mctFromLeafValues(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr.length == 2) {
            return arr[0] * arr[1];
        }

        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);

        for (int num : arr) {
            while (stack.peek() <= num) {
                int mid = stack.pop();
                ans += mid * Math.min(stack.peek(), num);
            }
            stack.push(num);
        }

        while (stack.size() > 2) {
            ans += stack.pop() * stack.peek();
        }

        return ans;
    }
}
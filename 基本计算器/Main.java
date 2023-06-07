import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.calculate("(7)-(0)+(4)");
        System.out.println("i: " + i);
    }
}

class Solution {
    public int calculate(String s) {
        s = s.replace(" ", "");
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        ArrayDeque<Character> charqueue = new ArrayDeque<Character>();
        // queue<Integer> kqueue= new queue<Integer>();
        int tmp = 0;
        var chars = s.toCharArray();
        int i = 0;
        while (i < chars.length) {
            // System.out.println("i=="+i);
            if (chars[i] >= '0' && chars[i] <= '9') {
                tmp = tmp * 10 + (chars[i] - '0');
                ++i;
            } else if (chars[i] == '+') {
                // if(tmp!=0){
                queue.add(tmp);
                tmp = 0;
                // }
                charqueue.add(chars[i]);
                ++i;

            } else if (chars[i] == '-') {
                queue.add(tmp);
                tmp = 0;
                charqueue.add(chars[i]);
                ++i;

            } else if (chars[i] == '(') {

                int[] nk = kcla(i, chars);
                tmp = nk[1];
                // queue.add(nk[1]);
                i = nk[0] + 1;

            }
        }
        queue.add(tmp);
        while (!charqueue.isEmpty()) {
            char op = charqueue.pop();
            int o1 = queue.pop();
            int o2 = queue.pop();
            // System.out.println("o1=="+o1+' '+"o2=="+o2);
            if (op == '+') {
                queue.addFirst(o1 + o2);
                ;
            } else {
                queue.addFirst(o1 - o2);
            }

        }
        return queue.pop();
    }

    int[] kcla(int ind, char[] chars) {
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        ArrayDeque<Character> charqueue = new ArrayDeque<Character>();
        // queue<Integer> kqueue= new queue<Integer>();
        int tmp = 0;
        // var chars=s.toCharArray();
        int i = ind + 1;
        while (i < chars.length) {
            if (chars[i] >= '0' && chars[i] <= '9') {

                tmp = tmp * 10 + (chars[i] - '0');
                ++i;
            } else if (chars[i] == '+') {
                // if(tmp!=0){
                queue.add(tmp);
                tmp = 0;
                // }
                charqueue.add(chars[i]);
                ++i;

            } else if (chars[i] == '-') {
                queue.add(tmp);
                tmp = 0;
                charqueue.add(chars[i]);
                ++i;

            } else if (chars[i] == '(') {
                int[] nk = kcla(i, chars);
                tmp = nk[1];
                // queue.add(nk[1]);
                i = nk[0] + 1;
            } else if (chars[i] == ')') {
                break;
            }
        }
        queue.add(tmp);
        // int ans=0;
        while (!charqueue.isEmpty()) {
            char op = charqueue.pop();
            int o1 = queue.pop();
            int o2 = queue.pop();
            // System.out.println("o1=="+o1+' '+"o2=="+o2);
            if (op == '+') {
                queue.addFirst(o1 + o2);
                ;
            } else {
                queue.addFirst(o1 - o2);
            }

        }
        return new int[] { i, queue.pop() };

    }
}
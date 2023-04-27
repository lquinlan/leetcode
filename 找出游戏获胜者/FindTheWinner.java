
import java.util.LinkedList;
import java.util.Queue;

public class FindTheWinner {
    public static void main(String[] args) {

    }
}

class Solution {
    Queue<Integer> queue1 = new LinkedList<Integer>();
    // Queue<Integer> queue2 = new LinkedList<Integer>();
    int N = 0;
    int K = 0;

    public int findTheWinner(int n, int k) {

        for (int i = 1; i <= n; ++i)
            queue1.add(i);
        N = n;
        K = k;
        while (queue1.size() != 1) {
            for (int i = 1; i <= K - 1; ++i) {
                int tmp = queue1.poll();
                queue1.add(tmp);
            }
            queue1.poll();

        }
        return queue1.peek();

    }
}
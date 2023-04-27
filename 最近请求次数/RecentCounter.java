import java.util.ArrayDeque;
import java.util.Deque;

public class RecentCounter {
    public static void main(String[] args) {
        System.out.println("f");

    }

    int cnt;
    int lastTime;
    int recentTime;
    Deque<Integer> time = new ArrayDeque<Integer>();

    RecentCounter() {
        cnt = 0;
        lastTime = -1;
        recentTime = -1;

    }

    int ping(int milliseconds) {
        time.addLast(milliseconds);
        lastTime = time.peekFirst();
        recentTime = time.peekLast();

        while (recentTime - lastTime > 3000) {
            time.pollFirst();
            lastTime = time.peekFirst();
            --cnt;
        }
        ++cnt;
        return cnt;

    }
}
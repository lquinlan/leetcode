import java.util.HashSet;
import java.util.PriorityQueue;

public class GetKthMagicNumber {
    public static void main(String[] args) {

    }
}

class Solution {
    public int getKthMagicNumber(int k) {
        int[] fac = { 3, 5, 7 };
        HashSet<Long> set = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        heap.offer(1L);
        set.add(1L);
        long cur = 0L;
        for (int i = 0; i < k; ++i) {
            cur = heap.poll();
            for (int j : fac) {
                Long tmp = cur * j;
                if (set.add(tmp)) {
                    heap.offer(tmp);
                }
            }
        }
        return (int) cur;

    }
}
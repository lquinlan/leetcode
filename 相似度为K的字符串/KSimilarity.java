import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class KSimilarity {
    public static void main(String[] args) {

    }
}

class Pair<T1, T2> {
    T1 first;
    T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getKey() {
        return first;
    }

    public T2 getValue() {
        return second;
    }
}

class Solution {
    public int kSimilarity(String s1, String s2) {
        int setp = 0;
        int len = s1.length();
        Queue<Pair<String, Integer>> queue = new ArrayDeque<Pair<String, Integer>>();
        Set<String> set = new HashSet<String>();
        queue.offer(new Pair<String, Integer>(s1, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                var tmp = queue.poll();
                String cur = tmp.getKey();
                int pos = tmp.getValue();
                if (cur.equals(s2)) {
                    return setp;
                }
                while (pos < len && cur.charAt(pos) == s2.charAt(pos)) {
                    ++pos;
                }
                for (int j = pos + 1; j < len; j++) {
                    if (cur.charAt(j) == s2.charAt(j)) {
                        continue;
                    }
                    if (cur.charAt(j) == s2.charAt(pos)) {
                        String newcur = swap(cur, j, pos);
                        if (!set.contains(newcur)) {
                            set.add(newcur);
                            queue.offer(new Pair<String, Integer>(newcur, pos + 1));

                        }
                    }
                }

            }
            ++setp;
        }
        return setp;

    }

    String swap(String s1, int i, int j) {
        var tmps = s1.toCharArray();
        char tmp = tmps[i];
        tmps[i] = tmps[j];
        tmps[j] = tmp;
        return new String(tmps);

    }
}
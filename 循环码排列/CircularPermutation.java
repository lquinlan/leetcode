import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CircularPermutation {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> result = new ArrayList<Integer>();
        // Set<Integer> set = new HashSet<Integer>();
        // set.add(start);
        result.add(start);
        int N = (1 << n) - 1;
        int[] visited = new int[N + 1];
        visited[start] = 1;
        // System.out.println(N);
        for (int i = 0; i < N; i++) {
            int prev = result.get(i);
            int off = -1;
            for (int j = n - 1; j >= 0; j--) {
                if (off != j) {
                    int tmp = prev ^ (1 << j);
                    if (visited[tmp] == 0) {
                        // set.add(tmp);
                        visited[tmp] = 1;
                        result.add(tmp);
                        prev = tmp;
                        off = j;
                        break;

                    }
                }

            }
        }

        return result;

    }
}
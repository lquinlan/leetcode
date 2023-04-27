import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Courses {
    public static void main(String[] args) {

    }
}

class Solution {
    List<List<Integer>> edges = new ArrayList<List<Integer>>();
    int[] deg;

    boolean topSort(int n) {
        int cnt = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int t = q.peek();
            q.poll();
            ++cnt;
            for (var i : edges.get(t)) {
                deg[i]--;
                if (deg[i] == 0) {
                    q.add(i);
                }
            }
        }
        return cnt == n;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        deg = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            List<Integer> tmp = new ArrayList<Integer>();
            edges.add(tmp);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            deg[prerequisites[i][0]]++;
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);

        }
        return topSort(numCourses);

    }
}
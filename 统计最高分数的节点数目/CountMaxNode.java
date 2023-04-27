import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;

public class CountMaxNode {
    public static void main(String[] args) {
        // Solution solution = new Solution();
        // int[] s = new int[] { -1, 2, 0, 2, 0 };
        // int ans = solution.countHighestScoreNodes(s);
        // System.out.println(ans);

    }
}

// class Solution {
// List<List<Integer>> graph;
// int[] visited;
// int count;

// void setGraph(int capacity) {
// graph = new ArrayList<List<Integer>>();
// for (int i = 0; i < capacity; i++) {
// List<Integer> nodes = new ArrayList<Integer>();
// graph.add(nodes);
// }
// visited = new int[capacity];
// count = 0;
// }

// void dfs(int node) {
// visited[node] = 1;
// // / boolean flag = false;

// for (int i = 0; i < graph.get(node).size(); i++) {
// if (visited[graph.get(node).get(i)] == 0) {
// visited[graph.get(node).get(i)] = 1;
// ++count;
// // System.out.println("dfs=" + graph.get(node).get(i) + ' ' + count);
// dfs(graph.get(node).get(i));
// visited[graph.get(node).get(i)] = 0;
// }
// }
// visited[node] = 0;

// return;

// }

// int getScore(int node) {
// int mul = 1;
// visited[node] = 1;
// for (int i = 0; i < graph.get(node).size(); i++) {
// ++count;
// dfs(graph.get(node).get(i));
// mul *= count;
// count = 0;
// // System.out.println("node=" + node + "mul = " + mul);

// }
// visited[node] = 0;
// return mul;
// }

// public int countHighestScoreNodes(int[] parents) {
// setGraph(parents.length);
// // System.out.println(parents.length);
// // System.out.println(graph.size());

// for (int i = 0; i < parents.length; i++) {
// if (parents[i] < 0) {
// continue;
// }
// graph.get(i).add(parents[i]);
// graph.get(parents[i]).add(i);
// }
// int[] score = new int[parents.length];
// for (int i = 0; i < parents.length; i++) {
// score[i] = getScore(i);
// // System.out.println("Score" + score[i]);
// }
// int ans = 1;
// Arrays.sort(score);
// for (int i = score.length - 1; i > 0; --i) {
// if (score[i] == score[i - 1]) {
// ans++;
// } else {
// break;
// }
// }
// return ans;

// }
// }

class Solution {
    long maxScore = 0;
    int cnt = 0;
    int n;
    List<Integer>[] children;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            int p = parents[i];
            if (p != -1) {
                children[p].add(i);
            }
        }
        dfs(0);
        return cnt;
    }

    public int dfs(int node) {
        long score = 1;
        int size = n - 1;
        for (int c : children[node]) {
            int t = dfs(c);
            score *= t;
            size -= t;
        }
        // 头当上的
        if (node != 0) {
            score *= size;
        }
        if (score == maxScore) {
            cnt++;
        } else if (score > maxScore) {
            maxScore = score;
            cnt = 1;
        }
        return n - size;
    }
}

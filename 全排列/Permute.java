import java.util.ArrayList;
import java.util.List;

public class Permute {
    public static void main(String[] args) {

    }
}

class Solution {
    List<List<Integer>> ans;
    List<Integer> tmp;
    int[] visited;

    Solution() {
        ans = new ArrayList<List<Integer>>();
        tmp = new ArrayList<Integer>();
    }

    void setVisited(int cap) {
        visited = new int[cap];
    }

    void dfs(int[] a, int d) {
        if (d >= a.length) {
            List<Integer> t = new ArrayList<Integer>(tmp);
            ans.add(t);
        }
        for (int i = 0; i < a.length; i++) {
            if (visited[i] != 1) {
                visited[i] = 1;
                tmp.add(a[i]);
                dfs(a, 1 + d);
                tmp.remove(tmp.size() - 1);
                visited[i] = 0;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        setVisited(nums.length);
        dfs(nums, 0);
        return ans;

    }
}
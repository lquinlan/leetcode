import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
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
        int cur = -1;
        for (int i = 0; i < a.length; i++) {
            if (i > 0 && cur == a[i]) {
                continue;
            }
            if (visited[i] != 1) {
                visited[i] = 1;
                tmp.add(a[i]);
                cur = a[i];
                dfs(a, 1 + d);
                tmp.remove(tmp.size() - 1);
                visited[i] = 0;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        setVisited(nums.length);
        dfs(nums, 0);
        return ans;

    }
}
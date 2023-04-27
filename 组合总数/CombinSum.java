import java.util.ArrayList;
import java.util.List;

public class CombinSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combinationSum(new int[] { 2, 3 }, 7);

    }
}

class Solution {

    List<List<Integer>> ans;
    List<Integer> tmp;

    Solution() {
        ans = new ArrayList<List<Integer>>();
        tmp = new ArrayList<Integer>();
    }

    void dfs(int[] nums, int ind, int tar, int sum) {
        if (sum == tar) {
            List<Integer> tm = new ArrayList<Integer>(tmp);
            ans.add(tm);
            return;
        } else if (sum > tar) {
            return;
        }

        for (int i = ind; i < nums.length; i++) {
            tmp.add(nums[i]);
            System.out.println(nums[i]);
            System.out.println("i=:" + i);
            dfs(nums, i, tar, sum + nums[i]);
            tmp.remove(tmp.size() - 1);
        }
        return;

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return null;
        }

        dfs(candidates, 0, target, 0);
        return ans;
    }
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombineSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[] { 10, 1, 2, 7, 6, 1, 5 };
        solution.combinationSum2(a, 8);

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
            System.out.println(tm.toString());
            return;
        } else if (sum > tar) {
            return;
        }

        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1]) {
                continue;

            }
            tmp.add(nums[i]);
            dfs(nums, i + 1, tar, sum + nums[i]);
            tmp.remove(tmp.size() - 1);
        }
        return;

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return null;
        }
        Arrays.sort(candidates);
        dfs(candidates, 0, target, 0);
        return ans;
    }
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    public static void main(String[] args) {

    }
}

class Solution {
    List<List<Integer>> list = new ArrayList<List<Integer>>();

    void dfs(int[] nums, int ind, List<Integer> tmp) {
        if (ind == nums.length) {
            return;
        }
        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1]) {
                continue;
            }
            List<Integer> tmp2 = new ArrayList<Integer>(tmp);
            tmp2.add(nums[i]);
            list.add(tmp2);
            dfs(nums, i + 1, new ArrayList<Integer>(tmp2));
            // tmp.remove(tmp.size() - 1);
        }

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        list.add(new ArrayList<Integer>());
        dfs(nums, 0, new ArrayList<Integer>());
        return list;

    }
}
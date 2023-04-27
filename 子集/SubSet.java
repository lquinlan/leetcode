import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {

    }
}

class Solution {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    List<Integer> tmp = new ArrayList<Integer>();
    int[] vist;

    void dfs(int[] nums, int d) {
        if (d >= nums.length) {
            return;
        }
        for (int i = d; i < nums.length; i++) {
            if (vist[i] == 0) {
                tmp.add(nums[i]);
                // System.out.println(tmp.toString());
                List<Integer> tt = new ArrayList<Integer>(tmp);
                list.add(tt);
                vist[i] = 1;
                dfs(nums, i + 1);
                tmp.remove(tmp.size() - 1);
                vist[i] = 0;
            }

        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        vist = new int[nums.length];
        list.add(tmp);
        dfs(nums, 0);
        return list;

    }
}
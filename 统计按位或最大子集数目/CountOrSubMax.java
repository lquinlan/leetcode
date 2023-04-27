import java.util.ArrayList;
import java.util.List;

public class CountOrSubMax {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] { 2, 2, 2 };
        solution.countMaxOrSubsets(nums);

    }
}

class Solution {
    int answer = 0;
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    List<Integer> tmp = new ArrayList<Integer>();
    int finmax = Integer.MIN_VALUE;
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

    int or(List<Integer> nums) {
        int res = 0;
        for (var i : nums) {
            res = res | i;
        }
        return res;
    }

    public int countMaxOrSubsets(int[] nums) {
        vist = new int[nums.length];
        dfs(nums, 0);
        for (List<Integer> i : list) {
            System.out.println("countMaxOrSubsets==" + i.toString());
            int tmp = or(i);
            System.out.println("or==" + tmp);
            if (tmp > finmax) {
                finmax = tmp;
                answer = 1;
            } else if (tmp == finmax) {
                ++answer;
            }
        }
        return answer;
    }
}
import java.util.ArrayList;
import java.util.List;

public class LexicalOrder {
    public static void main(String[] args) {

    }
}

// class Solution {
// public List<Integer> lexicalOrder(int n) {
// List<Integer> result = new ArrayList<Integer>();
// int nums = 1;
// for (int i = 1; i <= n; ++i) {
// result.add(nums);
// if (nums * 10 <= n) {
// nums *= 10;
// } else {
// while (nums % 10 == 9 || nums == n) {
// nums /= 10;
// }
// ++nums;
// }
// }
// return result;

// }
// }

class Solution {
    List<Integer> result = new ArrayList<Integer>();
    int cnt = 0;

    void dfs(int nums, int n) {
        if (cnt == n) {
            return;
        }
        result.add(nums);
        ++cnt;
        for (int i = 0; i < 10; ++i) {
            if (nums * 10 + i <= n) {
                dfs(nums * 10 + i, n);
            }

        }
        ++nums;
        dfs(nums, n);

    }

    public List<Integer> lexicalOrder(int n) {
        dfs(1, n);
        return result;

    }
}
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

// 暴力搜索+剪纸
class Solution {
    List<List<String>> list = new ArrayList<>();
    int ansMax = 0;
    HashSet<String> set = new HashSet<>();

    boolean check(int lev, int i, int j) {
        String tmpj = list.get(lev + 1).get(j);
        String tmpi = list.get(lev).get(i);
        int l = 0;
        int r = 0;
        while (l < tmpi.length() && r < tmpj.length()) {
            if (tmpi.charAt(l) == tmpj.charAt(r)) {
                ++l;
                ++r;
            } else {
                ++r;
            }
        }
        if (l >= tmpi.length()) {
            return true;
        }
        return false;
    }

    void dfs(int lev, int ind, int ans) {
        if (ans + lev <= ansMax) {
            return;
        }
        ansMax = Math.max(ans, ansMax);
        if (list.get(lev).size() == 0 || lev < 1) {
            return;
        }

        for (int i = 0; i < list.get(lev).size(); ++i) {
            if (check(lev, i, ind) && (!set.contains(list.get(lev).get(i)))) {
                set.add(list.get(lev).get(i));
                dfs(lev - 1, i, ans + 1);
            }
        }
    }

    public int longestStrChain(String[] words) {
        for (int i = 0; i <= 16; i++) {
            list.add(new ArrayList<String>());
        }
        for (String str : words) {
            list.get(str.length()).add(str);
        }
        for (int i = 16; i >= 1; --i) {
            if (i <= ansMax) {
                continue;
            }
            if (list.get(i).size() > 0) {
                for (int j = 0; j < list.get(i).size(); ++j) {
                    dfs(i - 1, j, 1);
                }
            }
        }
        return ansMax;
    }
}
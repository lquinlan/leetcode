import java.util.ArrayList;
import java.util.List;

public class NumMatchingSubseq {
    public static void main(String[] args) {

    }
}

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < 26; ++i) {
            list.add(new ArrayList<Integer>());

        }
        for (int i = 0; i < s.length(); ++i) {
            list.get(s.charAt(i) - 'a').add(i);
        }
        int ans = 0;
        for (String word : words) {
            int cur = -1;
            boolean found = true;
            for (int i = 0; i < word.length(); ++i) {
                int tmp = find(list.get(word.charAt(i) - 'a'), cur);
                if (tmp == -1) {
                    found = false;
                    break;
                } else {
                    cur = tmp;
                }

            }
            if (found) {
                ++ans;
            }

        }
        return ans;

    }

    int find(List<Integer> ind, int cur) {
        if (ind.size() == 0) {
            return -1;
        }
        int r = ind.size() - 1;
        int l = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (ind.get(mid) <= cur) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        if (l < ind.size()) {
            return ind.get(l);
        } else {
            return -1;
        }

    }
}
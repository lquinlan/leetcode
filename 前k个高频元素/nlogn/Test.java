import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args) {

    }
}

class Solution {
    class pair {
        int f;
        int s;

        pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        List<pair> list = new ArrayList<pair>();
        HashMap<Integer, pair> map = new HashMap<Integer, pair>();
        for (var i : nums) {
            if (map.containsKey(i)) {
                map.get(i).s = map.get(i).s + 1;
            } else {
                pair p = new pair(i, 1);
                list.add(p);
                map.put(i, p);
            }

        }
        list.sort(new Comparator<pair>() {
            public int compare(pair p1, pair p2) {
                return p2.s - p1.s;
            }
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = list.get(i).f;
        }
        return ans;

    }
}
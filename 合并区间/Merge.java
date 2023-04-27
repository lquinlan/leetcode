import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Merge {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < intervals.length; i++) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(intervals[i][0]);
            tmp.add(intervals[i][1]);
            result.add(tmp);
        }
        result.sort(new Comparator<List<Integer>>() {
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);

            }

        });
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int l = result.get(0).get(0);
        int r = result.get(0).get(1);
        // System.out.println(result.size());
        for (int i = 1; i < result.size(); i++) {
            // System.out.println(result.get(i).get(0)+' '+result.get(i).get(1));
            if (result.get(i).get(0) <= result.get(r).get(1)) {
                if (result.get(i).get(1) >= r) {
                    r = result.get(i).get(1);
                }
            } else {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(l);
                tmp.add(r);
                ans.add(tmp);
                l = result.get(i).get(0);
                r = result.get(i).get(1);

            }

        }
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(l);
        tmp.add(r);
        ans.add(tmp);
        // l = i;
        // r = i;

        int[][] fin = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); ++i) {
            fin[i][0] = ans.get(i).get(0);
            fin[i][1] = ans.get(i).get(1);
        }

        return fin;

    }
}
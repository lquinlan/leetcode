import java.util.ArrayList;
import java.util.List;

public class Insert {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> newIntervals = new ArrayList<List<Integer>>();
        int f = 0;
        int l = newInterval[0];
        int r = newInterval[1];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > r) {
                if (f == 0) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(l);
                    tmp.add(r);
                    newIntervals.add(tmp);
                    f = 1;

                }
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(intervals[i][0]);
                tmp.add(intervals[i][1]);
                newIntervals.add(tmp);
            } else if (intervals[i][1]<l) {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(intervals[i][0]);
                tmp.add(intervals[i][1]);

            } else {
                l=Math.min(l, intervals[i][0]);
                r-Math.max(r, intervals[i][1]);
            }
            
        }
        if (f == 0) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(l);
            tmp.add(r);
            newIntervals.add(tmp);
            f = 1;

        }
        int[][] answer = new int[newIntervals.size()][2];
        for (int i = 0; i < newIntervals.size(); i++) {
            answer[i][0] = newIntervals.get(i).get(0);
            answer[i][1] = newIntervals.get(i).get(1);

        }
        return answer;
    }
}
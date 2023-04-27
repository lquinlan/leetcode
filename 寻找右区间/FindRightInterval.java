import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class FindRightInterval {
    public static void main(String[] args) {

    }
}

class Solution {
    int find(int[][] intervals, int tar) {
        int l = 0;
        int r = intervals.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (intervals[mid][0] < tar) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        if (l < intervals.length && intervals[l][0] >= tar) {

            return l;
        } else
            return -1;
    }

    public int[] findRightInterval(int[][] intervals) {

        int[] res = new int[intervals.length];
        if (intervals.length == 1) {
            res[0] = -1;
            return res;
        }
        HashMap<int[], Integer> map = new HashMap<int[], Integer>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i], i);
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[0];

            }
        });
        for (int i = 0; i < intervals.length; i++) {
            int tmp = find(intervals, intervals[i][1]);
            if (tmp == -1) {
                res[map.get(intervals[i])] = -1;
            } else {
                res[map.get(intervals[i])] = map.get(intervals[tmp]);
            }

        }
        return res;

    }
}
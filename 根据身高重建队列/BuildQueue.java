import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BuildQueue {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return b[0] - a[0];

            }
        });

        List<int[]> result = new LinkedList<int[]>();
        for (var i : people) {
            result.add(i[1], i);
        }
        return result.toArray(new int[1][1]);

    }
}
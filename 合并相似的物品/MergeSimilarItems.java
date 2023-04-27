import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> MergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(items1, (a, b) -> a[0] - b[0]);
        Arrays.sort(items2, (a, b) -> a[0] - b[0]);
        int i = 0;
        int j = 0;
        while (i < items1.length && j < items2.length) {
            if (items1[i][0] < items2[j][0]) {
                List<Integer> newItems = new ArrayList<Integer>();
                newItems.add(items1[i][0]);
                newItems.add(items1[i][1]);
                result.add(newItems);
                ++i;
            } else if (items1[i][0] > items2[j][0]) {
                List<Integer> newItems = new ArrayList<Integer>();
                newItems.add(items2[j][0]);
                newItems.add(items2[j][1]);
                result.add(newItems);
                ++j;

            } else {
                List<Integer> newItems = new ArrayList<Integer>();
                newItems.add(items1[i][0]);
                newItems.add(items1[i][1] + items2[j][1]);
                result.add(newItems);
                ++j;
                ++i;

            }
        }
        while (i < items1.length) {
            List<Integer> newItems = new ArrayList<Integer>();
            newItems.add(items1[i][0]);
            newItems.add(items1[i][1]);
            result.add(newItems);
            ++i;
        }
        while (j < items2.length) {
            List<Integer> newItems = new ArrayList<Integer>();
            newItems.add(items2[j][0]);
            newItems.add(items2[j][1]);
            result.add(newItems);
            ++j;

        }

        return result;

    }
}
import java.util.ArrayList;
import java.util.List;

public class GetRow {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Integer> getRow(int rowIndex) {
        // List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> rows = new ArrayList<Integer>();
        rows.add(1);
        // result.add(new ArrayList<Integer>(rows));
        if (rowIndex == 0) {
            return rows;
        }
        rows.add(1);
        // result.add(new ArrayList<Integer>(rows));
        if (rowIndex == 1) {
            return rows;
        }
        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(1);
            for (int j = 0; j < rows.size() - 1; j++) {
                tmp.add(rows.get(j) + rows.get(j + 1));
            }
            tmp.add(1);
            // result.add(new ArrayList<Integer>(tmp));
            rows = tmp;

        }
        return rows;

    }
}
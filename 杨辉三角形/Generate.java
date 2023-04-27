import java.util.ArrayList;
import java.util.List;

public class Generate {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> rows = new ArrayList<Integer>();
        rows.add(1);
        result.add(new ArrayList<Integer>(rows));
        if (numRows == 1) {
            return result;
        }
        rows.add(1);
        result.add(new ArrayList<Integer>(rows));
        if (numRows == 2) {
            return result;
        }
        for (int i = 3; i <= numRows; i++) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(1);
            for (int j = 0; j < rows.size() - 1; j++) {
                tmp.add(rows.get(j) + rows.get(j + 1));
            }
            tmp.add(1);
            result.add(new ArrayList<Integer>(tmp));
            rows = tmp;

        }
        return result;

    }
}
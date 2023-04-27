import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < (1 << n); ++i) {
            result.add(i ^ (i >> 1));
        }
        return result;

    }
}
import java.util.ArrayList;
import java.util.List;

public class PlusOne {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        int f = 0;
        List<Integer> answer = new ArrayList<Integer>();
        for (int i = digits.length - 1; i >= 0; i--) {
            int tmp = digits[i] + f;
            if (tmp == 10) {
                answer.add(0);
                f = 1;
            } else {
                answer.add(tmp);
                f = 0;
            }
        }
        int[] re = new int[answer.size()];
        for (int i = re.length - 1; i >= 0; i--) {
            re[re.length - 1 - i] = answer.get(i);
        }
        return re;

    }
}
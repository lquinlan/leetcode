import java.util.ArrayList;
import java.util.List;

public class SelfDividNumbers {
    public static void main(String[] args) {

    }
}

class Solution {
    boolean check(int number) {
        int num = number;
        if (number == 0) {
            return false;
        }
        if (number >= 1 && number <= 9) {
            return true;
        } else {
            while (number != 0) {
                int tmp = number % 10;
                if (tmp == 0) {
                    return false;
                } else if (num % tmp != 0) {
                    return false;

                }
                number /= 10;
            }
        }
        return true;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = left; i <= right; i++) {
            if (check(i)) {
                result.add(i);

            }
        }

        return result;

    }
}
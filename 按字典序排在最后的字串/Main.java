import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {

    public String lastSubstring(String s) {
        int ind = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) > s.charAt(ind)) {
                ind = i;
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(ind)) {
                result.add(i);
            }
        }
        int len = s.length();
        int pos = result.get(0);
        for (int i = 1; i < result.size(); ++i) {
            int cur = result.get(i);
            int j = pos;
            while (cur < len && s.charAt(cur) == s.charAt(j)) {

                ++cur;
                ++j;

            }
            if (cur >= len) {
                break;
            }
            if (s.charAt(j) < s.charAt(cur)) {
                pos = result.get(i);
            }

        }
        return s.substring(pos, s.length());

    }
}
import java.util.ArrayList;
import java.util.List;

public class CountAnsSay {
    public static void main(String[] args) {

    }
}

class Solution {
    List<String> lines = new ArrayList<String>();

    Solution() {
        lines.add("1");
        for (int i = 1; i < 30; ++i) {

            String tmp = lines.get(i - 1);
            char prev = tmp.charAt(0);
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < tmp.length(); ++j) {
                if (tmp.charAt(j) == prev) {
                    ++count;
                } else {
                    char t = (char) ('0' + count);
                    sb.append(t);
                    sb.append(prev);
                    prev = tmp.charAt(j);
                    count = 1;

                }

            }
            char t = (char) ('0' + count);
            sb.append(t);
            sb.append(prev);
            lines.add(sb.toString());
        }
    }

    public String countAndSay(int n) {
        return lines.get(n - 1);

    }
}
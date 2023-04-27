import java.util.ArrayList;
import java.util.List;

public class FullJustify {
    public static void main(String[] args) {

    }
}

class Solution {
    String bulidmoreone(String[] words, int l, int r, int maxWidth, int len) {
        StringBuilder sb = new StringBuilder();
        len = len - (r - l);
        int avg = (maxWidth - len) / (r - l - 1);
        int modavg = (maxWidth - len) % (r - l - 1);
        for (int i = l; i < r - 1; ++i) {
            sb.append(words[i]);
            if (modavg > 0) {
                sb.append(' ');
                --modavg;

            }
            for (int j = 0; j < avg; ++j) {
                sb.append(' ');
            }

        }
        sb.append(words[r - 1]);

        return sb.toString();
    }

    String bulidLast(String[] words, int l, int r, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        // len = len - (r - l);
        // int avg = (maxWidth - len) / (r - l - 1);
        // int modavg = (maxWidth - len) % (r - l - 1);
        for (int i = l; i < r - 1; ++i) {
            sb.append(words[i]);
            sb.append(' ');

        }
        sb.append(words[r - 1]);
        int len = maxWidth - sb.length();
        for (int i = 0; i < len; ++i) {
            sb.append(' ');
        }

        return sb.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int l = 0;
        int r = 0;
        int curlen = 0;
        List<String> result = new ArrayList<String>();
        while (r < words.length && l < words.length) {
            if (words[r].length() + curlen <= maxWidth) {
                // ++r;
                curlen += (words[r].length() + 1);
                ++r;
            } else if ((r - l) > 1) {
                String tmp = bulidmoreone(words, l, r, maxWidth, curlen);
                result.add(tmp);
                // r;
                l = r;
                curlen = 0;

            } else if ((r - l) == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(words[l]);
                for (int j = 0; j < (maxWidth - words[l].length()); ++j) {
                    sb.append(' ');
                }
                result.add(sb.toString());
                // ++r;
                l = r;
                curlen = 0;

            }
        }
        String tmp = bulidLast(words, l, r, maxWidth);
        result.add(tmp);
        return result;

    }
}
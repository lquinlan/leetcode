import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {

    }
}

class Solution {
    List<String> ip = new ArrayList<String>();
    List<String> tmp = new ArrayList<String>();

    boolean check(String sub) {
        if (sub.length() > 3) {
            return false;
        }
        if (sub.length() == 1) {
            return true;
        }
        if (sub.length() > 1 && sub.charAt(0) == '0') {
            return false;
        }
        int ans = 0;
        for (int i = 0; i < sub.length(); i++) {
            ans = ans * 10 + (sub.charAt(i) - '0');
        }
        if (ans <= 255 && ans >= 1) {
            return true;
        } else {
            return false;
        }
    }

    void dfs(String s, int cur, int ind) {
        if (cur == 4) {
            StringBuilder t = new StringBuilder();
            for (var i : tmp) {
                t.append(i);
            }
            ip.add(t.toString());
            return;
        }
        if (cur < 3) {
            for (int i = ind; (i < ind + 3) && i < s.length(); i++) {
                String sub = s.substring(ind, i + 1);
                if (check(sub)) {
                    tmp.add(sub);
                    dfs(s, cur + 1, i + 1);
                    tmp.remove(tmp.size() - 1);
                }
            }

        } else {
            String sub = s.substring(ind, s.length());
            if (check(sub)) {
                tmp.add(sub);
                dfs(s, cur + 1, s.length());
                tmp.remove(tmp.size() - 1);
            }

        }

    }

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 16) {
            return ip;
        }
        dfs(s, 0, 0);
        return ip;

    }
}
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenPar {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> ans = solution.generateParenthesis(4);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}

class Solution {

    // List<String> answer;

    // Solution() {
    // answer = new ArrayList<String>();
    // // answer.add("()");
    // }

    List<String> dp(int n) {
        if (n == 1) {
            List<String> tmp = new ArrayList<String>();
            tmp.add("()");
            return tmp;
        }
        List<String> tmp = dp(n - 1);
        List<String> answer = new ArrayList<String>();
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < tmp.size(); ++i) {
            String s = tmp.get(i);
            // set.add(s + "()");
            // set.add("()" + s);
            // set.add("(" + s + ")");
            for (int j = 0; j < s.length(); ++j) {
                if (j == 0) {
                    set.add("()" + s);
                }
                if (j == s.length() - 1) {
                    set.add(s + "()");
                }
                set.add(s.substring(0, j) + "()" + s.substring(j, s.length()));
            }

        }
        for (String s : set) {
            answer.add(s);
        }
        return answer;
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = dp(n);
        return ans;

    }
}
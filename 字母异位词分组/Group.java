import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Group {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
        solution.groupAnagrams(strs);

    }
}

class Solution {
    List<List<String>> answer;

    Solution() {
        answer = new ArrayList<List<String>>();
    }

    void inanswer(String str) {
        char[] c = str.toCharArray();
        Arrays.sort(c);

        String trc = new String(c);
        // System.out.println(trc);
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).get(0).equals(trc)) {
                answer.get(i).add(str);
                return;
            }
        }

        List<String> l = new ArrayList<String>();
        l.add(trc);
        l.add(str);
        answer.add(l);

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return null;
        }

        for (int i = 0; i < strs.length; i++) {
            // System.out.println(strs[i]);
            inanswer(strs[i]);

        }
        // System.out.println(answer.toString());
        for (int i = 0; i < answer.size(); ++i) {
            answer.get(i).remove(0);
        }
        // System.out.println(answer.toString());
        return answer;
    }
}
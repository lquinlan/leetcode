import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCom {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> ans = solution.letterCombinations("292");
        for (String a : ans) {
            System.out.println(a);
        }

    }
}

class Solution {
    HashMap<Character, String> map = new HashMap<Character, String>();

    Solution() {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    List<String> pailie(String dig, int ind, StringBuilder qz) {
        if (ind >= dig.length()) {
            List<String> re = new ArrayList<String>();
            re.add(qz.toString());
            return re;
        }
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < map.get(dig.charAt(ind)).length(); ++i) {
            qz.append(map.get(dig.charAt(ind)).charAt(i));
            List<String> tmp = pailie(dig, ind + 1, qz);
            for (String t : tmp) {
                ans.add(t);
            }
            // System.out.println(ans);
            qz.deleteCharAt(qz.length() - 1);
        }
        return ans;
    }

    public List<String> letterCombinations(String digits) {

        StringBuilder qz = new StringBuilder();
        List<String> result = new ArrayList<String>();
        if (digits.length() == 0) {
            return result;
        }
        // String ans = "";
        for (int i = 0; i < map.get(digits.charAt(0)).length(); ++i) {
            qz.append(map.get(digits.charAt(0)).charAt(i));
            List<String> ans = pailie(digits, 1, qz);
            qz.deleteCharAt(qz.length() - 1);
            for (String a : ans) {
                result.add(a);
            }

        }

        return result;

    }
}

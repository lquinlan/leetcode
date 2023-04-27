import java.util.HashMap;

public class SubString {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcd"));
    }
}
// 暴力版本
// class Solution {
// public int lengthOfLongestSubstring(String s) {
// int max = 0;
// // System.out.println(s);
// for (int i = 0; i < s.length(); ++i) {
// Set<Character> set = new HashSet<Character>();
// for (int j = i; j < s.length(); ++j) {

// boolean f = set.add(s.charAt(j));
// // System.out.println(f);
// if (f != true) {
// max = set.size() > max ? set.size() : max;
// set.clear();
// // System.out.println(max);
// } else {
// max = set.size() > max ? set.size() : max;
// }

// }
// }
// return max;
// }
// }

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (map.get(tmp) == null) {
                map.put(tmp, i);
                // ++r;
            } else {
                int index = map.get(tmp);
                System.out.println(tmp);
                map.remove(tmp);
                map.put(tmp, i);
                max = max > (r - l) ? max : (r - l);
                System.out.println("l=" + l);
                System.out.println("r=" + r);
                if (l < index + 1) {
                    l = index + 1;
                }
                // ++r;
            }
            ++r;
        }
        max = max > (s.length() - l) ? max : (s.length() - l);
        return max;
    }
}
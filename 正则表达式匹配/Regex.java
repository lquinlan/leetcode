public class Regex {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aaa", "ab*a*c*a"));
    }
}

class Solution {
    public boolean isMatch(String s, String p) {

        if (p.isEmpty()) { // 当模式串为空时，字符串为空，则匹配成功，否则匹配失败
            return s.isEmpty();
        } else if (p.length() == 1) {
            return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        } else if (p.charAt(1) != '*') { // 判断模式串第二位不为 * 的情况
            return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                    && isMatch(s.substring(1), p.substring(1));
        } else // 判断当模式串第二位为 * 的情况
        {
            while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s, p.substring(2))) { // 若后序字符串匹配成功则返回 true
                    return true;
                }
                s = s.substring(1); // 消除字符串与模式串当前字符相等字符
            }
            return isMatch(s, p.substring(2)); // 继续匹配后序字符串
        }
    }
}
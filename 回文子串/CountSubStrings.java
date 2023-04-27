public class CountSubStrings {
    public static void main(String[] args) {

    }
}

class Solution {
    private int answer = 0;

    void count(int s, int e, String str) {
        while (s >= 0 && e < str.length() && str.charAt(s) == str.charAt(e)) {
            answer++;
            --s;
            ++e;
        }
    }

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            count(i, i, s);
            count(i, i + 1, s);

        }
        return answer;
    }
}
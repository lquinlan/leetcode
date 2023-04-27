public class CountConsistentStrings {
    public static void main(String[] args) {

    }
}

class Solution {
    short[] map = new short[26];

    public int countConsistentStrings(String allowed, String[] words) {
        for (int i = 0; i < allowed.length(); ++i) {
            map[allowed.charAt(i) - 'a'] = 1;
        }
        int ans = 0;
        for (String word : words) {
            boolean found = true;
            for (int j = 0; j < word.length(); ++j) {
                if (map[word.charAt(j) - 'a'] == 0) {
                    found = false;
                    break;
                }

            }
            if (found) {
                ++ans;
            }
        }
        return ans;

    }
}
public class IsAilenS {
    public static void main(String[] args) {

    }
}

class Solution {
    int[] map = new int[26];

    boolean sotred(String w1, String w2) {
        int i = 0;
        while (i < w1.length() && i < w2.length()) {
            if (map[w1.charAt(i) - 'a'] > map[w2.charAt(i) - 'a']) {
                return false;
            } else if (map[w1.charAt(i) - 'a'] < map[w2.charAt(i) - 'a']) {
                return true;

            }
            ++i;
        }
        if (w1.length() <= w2.length()) {
            return true;
        } else {
            return false;
        }
        // return true;
    }

    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1) {
            return true;
        }
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (!sotred(words[i - 1], words[i])) {
                return false;

            }

        }
        return true;

    }
}
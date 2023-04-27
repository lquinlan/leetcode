import java.util.Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestWprd {
    public static void main(String[] args) {
        String[] tt = new String[] {
                "htncv", "htncvn", "b", "mvaqrm", "mv", "mvaqr", "mva", "ht", "mvaq", "i", "h", "htnc" };
        Solution solution = new Solution();
        String as = solution.longestWord(tt);
        System.out.println(as);
    }
}

// class Solution {
// public String longestWord(String[] words) {

// Arrays.sort(words, new Comparator<String>() {
// public int compare(String s1, String s2) {
// if (s1.length() != s2.length()) {
// return s1.length() - s2.length();
// } else {
// // int t = -1;
// return s2.compareTo(s1);
// }
// }
// });
// String[] words2 = new String[words.length];
// System.arraycopy(words, 0, words2, 0, words.length);
// Arrays.sort(words2, new Comparator<String>() {
// public int compare(String s1, String s2) {
// if (s1.charAt(0) != s2.charAt(0)) {
// if (s1.charAt(0) < s2.charAt(0)) {
// return 1;
// } else {
// return -1;
// }
// } else {
// return s1.length() - s2.length();
// }
// }
// });
// for (String s : words) {
// System.out.println(s);
// }
// for (String s : words2) {
// System.out.println(s);
// }
// HashMap<String, Integer> map = new HashMap<String, Integer>();

// for (int i = 0; i < words.length; ++i) {
// if (words[i].length() == 1) {
// for (int j = 0; j < words.length; ++j) {
// if (words2[j] == words[i]) {
// map.put(words[i], j);
// break;
// }
// }

// } else {
// break;
// }

// }
// int maxlen = -1;
// int maxind = -1;
// String ans = "";
// for (int i = 0; i < words.length; ++i) {
// if (words[i].length() == 1) {
// int tmplen = 1;
// int j = 0;
// for (j = map.get(words[i]); j < words.length - 1; ++j) {
// int l1 = words2[j + 1].length();
// int l2 = words2[j].length() + 1;
// if (l1 == l2) {
// if (words2[j + 1].charAt(l2 - 2) == words2[j].charAt(l2 - 2)) {
// tmplen++;

// }
// } else if (words2[j + 1].length() == words2[j].length() && words2[j +
// 1].length() > 1) {
// if (words2[j + 1].charAt(words2[j + 1].length() - 2) == words2[j]
// .charAt(words2[j].length() - 2)) {
// continue;
// } else {
// break;
// }

// } else {
// break;
// }
// }
// if (j == words.length - 1 && words2[j].length() >= words2[j - 1].length()) {
// tmplen++;
// }
// if (tmplen >= maxlen) {
// maxlen = tmplen;
// maxind = j;
// }

// } else {
// break;
// }

// }
// if (maxind != -1) {
// ans = words2[maxind];
// }

// return ans;

// }
// }

class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return b.compareTo(a);
            }
        });
        for (String word : words) {
            System.out.println(word);
        }
        String longest = "";
        Set<String> candidates = new HashSet<String>();
        candidates.add("");
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            if (candidates.contains(word.substring(0, word.length() - 1))) {
                candidates.add(word);
                longest = word;
            }
        }
        return longest;
    }
}

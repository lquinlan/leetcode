public class UniqueMorseRepresentations {
    public static void main(String[] args) {

    }
}

class Solution {

    int gethashCode(StringBuilder cur) {
        int hashCode = 0;
        for (int i = 0; i < cur.length(); ++i) {
            if (cur.charAt(i) == '.') {
                hashCode += (13 << (i % 3)) + (i + 2) * 34;
            } else {
                hashCode += (17 << (i % 7)) + (i + 3) * 17;
            }
        }

        return hashCode;
    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] map = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
                "--.." };
        int ans = 0;
        int[] cnt = new int[13000];

        for (var i : words) {
            StringBuilder tmp = new StringBuilder();
            for (var j : i.toCharArray()) {
                tmp.append(map[j - 'a']);
            }
            int hashCode = gethashCode(tmp);
            if (cnt[hashCode] == 0) {
                ++ans;
                cnt[hashCode] = 1;
            }

        }
        return ans;

    }
}
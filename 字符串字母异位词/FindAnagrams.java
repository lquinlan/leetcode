import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    public static void main(String[] args) {

    }
}

class Solution {
    int[] maps = new int[26];
    int[] mapp = new int[26];

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<Integer>();
        if (s.length() < p.length()) {
            return answer;
        }
        for (int i = 0; i < p.length(); i++) {
            maps[s.charAt(i) - 'a']++;
            mapp[p.charAt(i) - 'a']++;

        }
        if (Arrays.equals(maps, mapp)) {
            answer.add(0);

        }
        for (int i = p.length(); i < s.length(); ++i) {
            maps[s.charAt(i) - 'a']++;
            maps[s.charAt(i - p.length()) - 'a']--;
            if (Arrays.equals(maps, mapp)) {
                answer.add(i);
            }
        }
        return answer;

    }
}
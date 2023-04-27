import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindSubString {
    public static void main(String[] args) {

    }

}

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        int wordlen = words[0].length();
        int alllen = words.length * wordlen;
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        for (var i : words) {
            map1.put(i, map1.getOrDefault(i, 0));

        }
        for (int i = 0; i < s.length() - alllen + 1; i++) {
            String tmp_str = s.substring(i, i + alllen);
            HashMap<String, Integer> map2 = new HashMap<String, Integer>();
            for (int j = 0; j < tmp_str.length(); j += wordlen) {
                String tmp = tmp_str.substring(j, j + wordlen);
                map2.put(tmp, map2.getOrDefault(tmp, 0));

            }
            if (map1.equals(map2)) {
                result.add(i);
            }

        }

        return result;

    }
}
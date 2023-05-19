import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) {
            return new ArrayList<>();
        }

        int i = 0, j = 10;
        Map<String, Integer> map = new HashMap<>();
        while (j <= s.length()) {
            map.put(s.substring(i, j), map.getOrDefault(s.substring(i, j), 0) + 1);
            i++;
            j++;

        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                list.add(entry.getKey());
            }
        }
        return list;

    }
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubdomainVisits {
    public static void main(String[] args) {

    }
}

class Solution {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    List<String> result = new ArrayList<String>();

    void split(String i) {
        String[] parts = i.split(" ");
        // System.out.println(parts[0]);
        int cnt = Integer.parseInt(parts[0]);
        map.put(parts[1], map.getOrDefault(parts[1], 0) + cnt);

        while (true) {
            // System.out.println(parts[1]);
            String[] tmp = parts[1].split("\\.", 2);
            // System.out.println(tmp.length);
            if (tmp.length == 1) {
                break;
            }
            // System.out.println(tmp[1]);
            map.put(tmp[1], map.getOrDefault(tmp[1], 0) + cnt);
            parts[1] = tmp[1];

        }

    }

    public List<String> subdomainVisits(String[] cpdomains) {

        for (int i = 0; i < cpdomains.length; i++) {
            split(cpdomains[i]);
        }
        var s = map.keySet();
        for (var i : s) {
            int cnt = map.get(i);
            String tmp = cnt + " " + i;
            result.add(tmp);
        }
        return result;

    }
}
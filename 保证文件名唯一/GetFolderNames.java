import java.util.HashMap;
import java.util.Map;

public class GetFolderNames {
    public static void main(String[] args) {

    }
}

class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] ans = new String[names.length];
        int i = 0;
        for (String name : names) {
            if (!map.containsKey(name)) {
                map.put(name, 1);
                ans[i++] = name;
            } else {
                int k = map.get(name);
                String tmp = name + "(" + k + ")";
                while (map.containsKey(tmp)) {
                    ++k;
                    tmp = name + "(" + k + ")";

                }
                map.put(name, k + 1);
                map.put(tmp, 1);

                ans[i++] = tmp;
            }
        }

        return ans;

    }
}

import java.util.HashMap;

public class TotalFruit {
    public static void main(String[] args) {

    }
}

class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0;
        int r = 0;
        int res = -1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (r < fruits.length) {
            int i = fruits[r++];
            if (map.size() <= 2) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            while (map.size() == 3) {
                int j = fruits[l++];
                map.put(j, map.get(j) - 1);
                if (map.get(j) == 0) {
                    map.remove(j);
                }

            }
            System.out.println(l + " " + r);
            res = Math.max(res, r - l);

        }
        return res;

    }
}
import java.util.HashMap;
import java.util.Map;

public class FindLongestSubarray {
    public static void main(String[] args) {

    }
}

class Solution {
    public String[] findLongestSubarray(String[] array) {
        if (array.length == 0 || array.length == 1) {
            return new String[0];
        }
        int[] newarray = new int[array.length];
        for (int i = 0; i < newarray.length; i++) {
            if (Character.isLetter(array[i].charAt(0))) {
                newarray[i] = 1;
            } else {
                newarray[i] = -1;
            }
        }
        int[] presum = new int[newarray.length];
        presum[0] = newarray[0];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(presum[0], 0);
        for (int i = 1; i < newarray.length; i++) {
            presum[i] = presum[i - 1] + newarray[i];
            if (!map.containsKey(presum[i])) {
                map.put(presum[i], i);
            }

        }
        int maxlen = 0;
        int l = -1;
        int r = -1;
        for (int i = 0; i < newarray.length; i++) {
            if (presum[i] == 0) {
                if ((i + 1) > maxlen) {
                    l = 0;
                    r = 1;
                    maxlen = i + 1;
                }

            } else if (map.containsKey(presum[i])) {
                int ind = map.get(presum[i]);
                if ((i - ind) > maxlen) {
                    l = ind + 1;
                    r = i;
                    maxlen = i - ind;

                }
            }

        }

        if (l == -1 || r == -1) {
            return new String[0];

        }

    }

}

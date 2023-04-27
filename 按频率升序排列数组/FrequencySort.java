import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FrequencySort {
    public static void main(String[] args) {

    }
}

class Solution {
    int[] map = new int[201];

    public int[] frequencySort(int[] nums) {
        List<Integer> newNums = new ArrayList<Integer>();
        for (int i : nums) {
            map[100 - i]++;
            newNums.add(i);
        }
        // Integer newNums[] = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Collections.sort(newNums, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (map[100 - a] == map[100 - b]) {
                    return b - a;
                } else {
                    return map[100 - a] - map[100 - b];
                }

            }
        });
        // int[] ints = Arrays.stream(newNums).mapToInt(Integer::valueOf).toArray();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums.get(i);

        }
        return nums;

    }
}
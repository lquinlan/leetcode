public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    int[] map = new int[100004];
    public int mostFrequentEven(int[] nums) {
        int max=-1;
        for (var i : nums) {
            if ((i & 1) == 0) {
                ++map[i];
                max=Math.max(max, i);
            }
        }
        int ans = 0;
        for (int i = 0; i <=max; i += 2) {
            if (map[i] > map[ans]) {
                ans = i;
            }
        }
        if (map[ans] == 0) {
            return -1;
        } else {
            return ans;
        }

    }
}
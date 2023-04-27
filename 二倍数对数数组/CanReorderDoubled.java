public class CanReorderDoubled {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] { 4, -2, 2, -4 };
        System.out.println(solution.canReorderDoubled(arr));

    }
}

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        int[] map = new int[400000 + 2];
        int offest = 200000;
        int maxpos = Integer.MIN_VALUE;
        int minpos = Integer.MAX_VALUE;
        for (var i : arr) {
            map[i + offest]++;
            maxpos = Math.max(maxpos, i + offest);
            minpos = Math.min(minpos, i + offest);
        }
        if (map[offest] % 2 != 0) {
            return false;
        }
        int l = offest - 1;
        int r = offest + 1;
        while (l >= minpos || r <= maxpos) {
            while (l >= minpos && map[l] == 0) {
                --l;
            }
            while (r <= maxpos && map[r] == 0) {
                ++r;
            }
            // System.out.println("l==" + l);
            if (l >= minpos && map[(l - offest) * 2 + offest] < map[l]) {
                return false;
            }
            if (r <= maxpos && map[(r - offest) * 2 + offest] < map[r]) {
                return false;
            }
            if (l >= minpos) {
                map[(l - offest) * 2 + offest] -= map[l];
                --l;
            }
            if (r <= maxpos) {
                map[(r - offest) * 2 + offest] -= map[r];

                ++r;

            }

        }
        return true;

    }
}
class Solution {
    public int reachNumber(int target) {
        long s = 0;
        target = Math.abs(target);
        for (int i = 1; i <= target + 1; i++) {
            s += i;
            long c = s - target;
            if (c >= 0 && c % 2 == 0) {
                return i;
            }
        }
        return target;

    }
}
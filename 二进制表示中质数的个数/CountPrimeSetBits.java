public class CountPrimeSetBits {
    public static void main(String[] args) {

    }
}

class Solution {
    int getbits(int number) {
        int cnt = 0;
        while (cnt != 0) {
            cnt += cnt % 2;
            cnt /= 2;
        }
        return cnt;
    }

    public int countPrimeSetBits(int left, int right) {
        int[] primeSet = new int[40];
        primeSet[2] = 1;
        primeSet[3] = 1;
        primeSet[5] = 1;
        primeSet[7] = 1;
        primeSet[11] = 1;
        primeSet[13] = 1;
        primeSet[17] = 1;
        primeSet[19] = 1;
        primeSet[23] = 1;
        primeSet[29] = 1;
        primeSet[31] = 1;
        primeSet[37] = 1;
        int cnt = 0;
        for (int i = left; i <= right; i++) {
            cnt += primeSet[getbits(i)];
        }

        return cnt;

    }
}
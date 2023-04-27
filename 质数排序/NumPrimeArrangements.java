import java.util.ArrayList;
import java.util.List;

public class NumPrimeArrangements {
    public static void main(String[] args) {

    }
}

class Solution {
    boolean[] isnp = new boolean[107];
    List<Integer> primes = new ArrayList<Integer>();
    int[] map = new int[107];
    final int Mod = (int) (1e9 + 7);

    void init(int n) {
        for (int i = 2; i <= n; i++) {
            if (!isnp[i])
                primes.add(i);
            for (int p : primes) {
                if (p * i > n)
                    break;
                isnp[p * i] = true;
                if (i % p == 0)
                    break;
            }
        }
        for (int i = 2; i <= 100; ++i) {
            if (isnp[i]) {
                map[i] = map[i - 1] + 1;
            } else {
                map[i] = map[i - 1];
            }
        }
    }

    public int numPrimeArrangements(int n) {
        init(100);
        System.out.println(Mod);
        int l = map[n];
        int r = n - l;
        int ans = 1;
        for (int i = 1; i <= l; ++i) {
            ans = (ans * i) % Mod;
        }
        for (int i = 1; i <= r; ++i) {
            ans = (ans * i) % Mod;

        }
        return ans;

    }
}
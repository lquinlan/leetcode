public class Decrypt {
    public static void main(String[] args) {

    }
}

class Solution {
    void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int tmp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = tmp;
        }
    }

    public int[] decrypt(int[] code, int k) {
        if (k == 0) {
            return new int[code.length];
        }
        int[] result = new int[code.length];
        int f = 0;
        if (k < 0) {
            reverse(code);
            k = -k;
            f = 1;
        }
        // System.out.println(code.length);
        for (int i = 0; i < code.length; i++) {
            // System.out.println(code[i]);
            int sum = 0;
            for (int j = 1; j <= k; j++) {
                sum += code[(i + j) % code.length];
                // System.out.println(sum);
            }
            result[i] = sum;
        }
        if (f == 1) {
            reverse(result);
        }
        return result;
    }
}
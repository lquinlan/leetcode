public class RomanToInt {
    public static void main(String[] args) {

    }
}

class Solution {
    int[] val = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] roman = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    int ans = 0;

    int get(String s, int ind, int i) {
        if (s.startsWith(roman[i], ind)) {
            ans += val[i];
            ind += roman[i].length();

        }
        return ind;

    }

    public int romanToInt(String s) {

        int ind = 0;
        for (int i = 0; i < roman.length; i++) {
            ind = get(s, ind, i);

        }
        return ans;

    }
}
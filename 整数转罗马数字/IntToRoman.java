public class IntToRoman {
    public static void main(String[] args) {

    }
}

class Solution {
    public String intToRoman(int num) {
        StringBuilder answer = new StringBuilder();
        int[] val = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] roman = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        for (int i = 0; i < val.length; i++) {
            while (num > val[i]) {
                num -= val[i];
                answer.append(roman[i]);
            }
        }
        return answer.toString();

    }
}
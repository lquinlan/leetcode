public class MaxRepeating {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxRepeating(String sequence, String word) {
        int ans = 0;
        ;

        for (int i = 0; i < sequence.length(); ++i) {
            int ins = i;
            int last = -1;
            int tmp = 0;
            while (ins + word.length() <= sequence.length()) {
                int ind = sequence.indexOf(word, ins);
                // System.out.println(ind);
                if (ind != -1 && last != -1 && last + word.length() == ind) {
                    ++tmp;
                    last = ind;

                } else if (ind == -1) {
                    ans = Math.max(ans, tmp);
                    break;
                } else if (ind != -1 && last == -1) {
                    last = ind;
                    ++tmp;

                } else if (ind != -1 && last != -1 && last + word.length() != ind) {
                    ans = Math.max(ans, tmp);
                    tmp = 0;
                    last = ind;
                }
                ins += word.length();
                ans = Math.max(ans, tmp);
            }
        }
        return ans;

    }
}
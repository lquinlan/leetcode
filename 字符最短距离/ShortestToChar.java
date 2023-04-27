public class ShortestToChar {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        int i = 0;
        int ind = -1;
        int tmp = -1;
        while (i < s.length()) {
            tmp = ind;
            ind = s.indexOf(c, tmp + 1);
            if (ind != -1) {
                if (tmp == -1) {
                    for (; i <= ind; ++i) {
                        result[i] = ind - i;
                    }

                } else {
                    int mid = (ind - tmp - 1) / 2;
                    int f = tmp + mid;
                    for (; i <= ind; ++i) {
                        if (i <= f) {
                            result[i] = i - tmp;
                        } else {

                            result[i] = ind - i;
                        }

                    }
                }

            } else {
                for (; i < s.length(); ++i) {
                    result[i] = i - tmp;
                }
            }

        }
        return result;

    }
}
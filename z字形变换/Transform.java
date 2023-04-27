public class Transform {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convert("abcd", 2));

    }
}

class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }
        char[][] trans = new char[numRows][1005];
        boolean flag = false;
        int x = 0;
        int y = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < 1005; j++) {
                trans[i][j] = '*';
            }
        }
        for (int i = 0; i < s.length(); ++i) {
            if (flag == true) {
                trans[x][y] = s.charAt(i);
                x--;
                y++;
            } else {
                trans[x][y] = s.charAt(i);
                x++;
            }
            if (x <= 0) {
                flag = false;
                y++;
                x = 0;

            }
            if (x == numRows) {

                x -= 2;
                if (x > 0) {
                    flag = true;
                    // y++;
                }
                y++;
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= y; j++) {
                if (trans[i][j] == '*') {
                    continue;
                }
                sb.append(trans[i][j]);

            }
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= y; j++) {
                System.out.print(trans[i][j]);

            }
            System.out.println("");
        }
        return sb.toString();

    }
}
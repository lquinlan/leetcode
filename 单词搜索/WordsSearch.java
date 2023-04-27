public class WordsSearch {
    public static void main(String[] args) {
        char[][] words = new char[][] { { 'c', 'a', 'a' }, { 'a', 'a', 'a' }, { 'b', 'c', 'd' } };
        String s = "aab";
        Solution solution = new Solution();
        boolean f = solution.exist(words, s);
        System.out.println(f);

    }
}

class Solution {
    short[][] visited;
    short[][] on = new short[][] { { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };

    boolean dfs(char[][] board, String word, int x, int y, int d) {
        if (d >= word.length()) {
            return true;
        }
        visited[x][y] = 1;
        boolean found = false;
        for (int ii = 0; ii < 4; ii++) {

            int i = on[ii][0];
            int j = on[ii][1];
            if ((board.length - (x + i)) > 0 && (board.length - (x + i)) <= board.length
                    && (board[0].length - (y + j)) > 0 && (board[0].length - (y + j)) <= board[0].length
                    && board[x + i][y + j] == word.charAt(d)
                    && visited[x + i][y + j] == 0) {
                visited[i + x][y + j] = 1;
                found = dfs(board, word, x + i, y + j, d + 1);
                if (found == true) {
                    return found;
                }
                visited[i + x][y + j] = 0;
            }

        }
        visited[x][y] = 0;
        return found;

    }

    public boolean exist(char[][] board, String word) {
        visited = new short[board.length][board[0].length];
        boolean found = false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // if (i == 1 && j == 1) {
                // System.out.println("ff");
                // }
                if (board[i][j] == word.charAt(0)) {
                    found = dfs(board, word, i, j, 1);
                    if (found == true) {
                        return found;
                    }
                }
            }
        }
        return found;

    }
}
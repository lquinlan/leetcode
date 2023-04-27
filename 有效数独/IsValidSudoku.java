public class IsValidSudoku {
    public static void main(String[] args) {

    }
}

class Solution {
    int[] map = new int[9];

    void clearmap() {
        for (int i = 0; i < map.length; i++) {
            map[i] = 0;
        }
    }

    boolean isvalidrow(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            clearmap();
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.')
                    continue;
                if (map[board[i][j] - '1'] == 1) {
                    return false;

                } else {
                    map[board[i][j] - '1'] = 1;
                }
            }
        }
        return true;

    }

    boolean isvalids(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            clearmap();
            for (int j = 0; j < 9; ++j) {
                if (board[j][i] == '.')
                    continue;
                if (map[board[j][i] - '1'] == 1) {
                    return false;

                } else {
                    map[board[j][i] - '1'] = 1;
                }
            }
        }
        return true;

    }

    boolean subvalids(char[][] board) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                clearmap();
                for (int k = i; k < i + 3; ++k) {

                    for (int l = j; l < j + 3; ++l) {
                        if (board[k][l] == '.')
                            continue;
                        if (map[board[k][l] - '1'] == 1) {
                            return false;
                        } else {
                            map[board[k][l] - '1'] = 1;
                        }

                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        if (isvalidrow(board)) {
            if (isvalids(board)) {
                if (subvalids(board)) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }

        } else {
            return false;
        }

    }
}
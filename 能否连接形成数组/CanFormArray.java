public class CanFormArray {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            int len = pieces[i].length;
            boolean result = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == pieces[i][0]) {
                    if (j + len > arr.length) {
                        return false;
                    }
                    for (int k = 1; k < len; k++) {
                        if (arr[j + k] != pieces[i][k]) {
                            return false;
                        }
                    }
                    result = true;
                }
                if (result) {
                    break;
                }
            }
            if (!result) {
                return false;
            }

        }
        return true;

    }
}
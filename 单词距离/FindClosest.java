public class FindClosest {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int w1 = 4000000;
        int w2 = -1000000;
        int min = 100000;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                w1 = i;
            }
            if (words[i].equals(word2)) {
                w2 = i;
            }
            min = Math.min(min, Math.abs(w1 - w2));
        }
        return min;

    }
}
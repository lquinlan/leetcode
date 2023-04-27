public class ArrayStringsAreEqual {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // boolean result = false;
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for (String word : word1) {
            str1.append(word);
        }
        for (String word : word2) {
            str2.append(word);
        }
        if (str1.toString().equals(str2.toString())) {
            return true;
        } else {
            return false;
        }

    }
}
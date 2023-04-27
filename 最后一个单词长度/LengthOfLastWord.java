public class LengthOfLastWord {
    public static void main(String[] args) {

    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        String[] map = s.split(" ");
        return map[map.length - 1].length();
    }
}
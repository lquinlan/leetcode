public class IsFlipedString {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isFlipedString(String s1, String s2) {
        String s3 = s1 + s1;
        if (s1.length() == s2.length() && s3.contains(s2))
            return true;

        return false;

    }
}
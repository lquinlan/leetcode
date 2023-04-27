import java.util.HashSet;

public class HalvesAreAlike {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean halvesAreAlike(String s) {
        HashSet<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int mid = s.length() / 2;
        int ans1 = 0;
        int ans2 = 0;
        for (int i = 0; i < mid; i++) {
            if (set.contains(s.charAt(i))) {
                ++ans1;
            }
        }
        for (int i = mid; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                ++ans2;
            }
        }
        if (ans1 == ans2) {
            return true;
        } else {
            return false;
        }

    }
}
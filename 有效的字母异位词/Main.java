import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    public boolean isAnagram(String s, String t) {
        var s1=s.toCharArray();
        var t1=t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1,t1);

    }
}
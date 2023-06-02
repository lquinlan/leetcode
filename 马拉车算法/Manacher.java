import java.util.Arrays;

public class Manacher {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abacc"));
        
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] t = preprocess(s);
        System.out.println(Arrays.toString(t));
        int n = t.length;
        int[] p = new int[n];
        
        int center = 0, right = 0;
        for (int i = 1; i < n - 1; i++) {
            if (right > i) {
                p[i] = Math.min(right - i, p[2 * center - i]);
            }
            while (t[i + p[i] + 1] == t[i - p[i] - 1]) {
                p[i]++;
            }
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
            // if (p[i] > maxLen) {
            //     maxLen = p[i];
            //     maxIndex = i;
            // }
        }
        int maxs=0;int maxlen=0;
        for(int i=0;i<p.length;++i){
            if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                int st=(i-p[i]-1)/2;
                if(st==0&&p[i]>maxlen){
                    maxlen=p[i];
                    maxs=st+p[i];
                }
            }

        }
        System.out.println(maxIndex);
        System.out.println(maxLen);
        System.out.println(Arrays.toString(p));
        int start = (maxIndex - maxLen - 1) / 2;
        int end = start + maxLen;

        return s.substring(start, end);
    }
    
    private static char[] preprocess(String s) {
        int n = s.length();
        char[] t = new char[n * 2 + 3];
        t[0] = '$';
        t[n * 2 + 2] = '#';
        for (int i = 0; i < n; i++) {
            t[i * 2 + 1] = '#';
            t[i * 2 + 2] = s.charAt(i);
        }
        t[n * 2 + 1] = '#';
        return t;
    }
    
}

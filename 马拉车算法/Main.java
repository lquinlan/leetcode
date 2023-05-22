public class Main {
    public static void main(String[] args) {

    }

}

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars = preprocess(s);
        int center = 0;
        int right=0;
        int maxLen=0;
        int ansind=0;
        int[] L=new int[chars.length];
        for(int i=1;i<chars.length-1;i++){
            if(right>i){
                L[i]=Math.min(right-i,L[2*center-i]);
            }
            while(chars[i+L[i]+1]==chars[i-L[i]-1]){
                L[i]++;
            }
            if(i+L[i]>right){
                right=i+L[i];
                center=i;
            }
            if(L[i]>maxLen){
                maxLen=L[i];
                ansind=i;
            }
        }
        int start=(ansind-maxLen-1)/2;
        int end=start+maxLen;
        return s.substring(start,end);


    }
    char[] preprocess(String s) {
        char[] chars = new char[s.length()*2+3];
        chars[0]='$';
        chars[chars.length-1]='#';
        for (int i = 0; i < s.length(); i++) {
            chars[i*2+1] = '#';
            chars[i*2+2] = s.charAt(i);
        }
        chars[chars.length-2]='#';
        return chars;
        
    }
}

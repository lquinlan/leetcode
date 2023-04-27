public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int countSubstrings(String s, String t) {
        int answer = 0;
        int slen=s.length();
        int tlen=t.length();
        for (int i = 0; i < slen; i++) { 
            for (int j = 0; j < tlen; j++) { 
                int c=0;
                for (int k = 0; k < Math.min(slen-i,tlen - j); k++) { 
                    if(s.charAt(i+k)!=t.charAt(j+k)) {
                        c++;
                    }
                    if (c ==1 ) {
                        ++answer;
                        // break;
                    }
                    if(c>1){
                        break;
                    }

                }
            }
        }
        return answer;

    }
}
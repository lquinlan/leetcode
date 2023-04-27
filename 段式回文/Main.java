public class Main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    public int longestDecomposition(String text) {
        int l=0;
        int r=text.length();
        int lastl=l;
        int lastr=r;
        int ans=0;
        int len=0;
        while(l+1<r){
             
            if(text.substring(lastl, l+1).equals(text.substring(r-1,lastr))){
            //  System.out.println(text.substring(r-1,lastr));
                ans+=2;
                len+=(l+1-lastl)*2;
                lastl = l+1;
                lastr = r-1;
                
               
            }
            ++l;
            --r;

        }
        // System.out.println(text.substring(r-1,lastr));
        if(len!=text.length()){
            ++ans;
        }
        return ans;

    }
}
import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int[] diff = new int[reward1.length];
        int ans=0;
        for (int i = 0; i < reward1.length; i++){
            diff[i] = reward1[i]-reward2[i];
            ans+=reward2[i];
        }
        Arrays.sort(diff);
       
        for(int i=1;i<=k;i++){
            ans+=diff[diff.length-i];
        }
        return ans;

    }
}
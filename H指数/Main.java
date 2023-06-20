import java.util.Arrays;


class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int N=citations.length;
        int h=0;
        for(int i=N-1; i>=0; i--) {
            if(citations[i] >h){
                ++h;
            }
        }
        return h;
    }
}
// 0 1 3 5 6
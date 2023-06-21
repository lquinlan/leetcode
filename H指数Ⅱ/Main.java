class Solution {
    public int hIndex(int[] citations) {
        int l=0;
        int r=citations.length-1;
        int N=citations.length;
        while(l<=r){
            int mid=(l+r)/2;
            if(citations[mid]>=(N-mid)){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return N-l;

    }
}
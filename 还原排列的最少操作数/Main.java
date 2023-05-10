public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int reinitializePermutation(int n) {
        if (n == 2){
            return 1;
        }
        int[] arr=new int[n];
        int[] perm=new int[n];
        for(int i=0;i<n;i++){
            perm[i]=i;
        }
        int ans=0;
        do{
            for(int i=0;i<n;++i){
                if(i%2==0){
                    arr[i]=perm[i/2];
                }else{
                    arr[i]=perm[n/2+(i-1)/2];
                }
            }
            for(int i=0;i<n;++i){
                perm[i]=arr[i];
            }
            ++ans;
        }while(!check(perm));
        return ans;

    }

    boolean check(int[] arr) {
        for(int i=0;i<arr.length;++i){
            if(arr[i]!=i){
                return false;
            }
        }
        return true;
    }
}
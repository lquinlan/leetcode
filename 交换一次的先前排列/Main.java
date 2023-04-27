public class Main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int len = arr.length;
        for(int i=len-2;i>=0;--i){
            if(arr[i]>arr[i+1]){
                int j=len-1;
                while(arr[j]>=arr[i]||arr[j]==arr[j-1]){
                    --j;
                }
                int tmp=arr[j];
                arr[j]=arr[i];
                arr[i] = tmp;
                break;
            }
        }
        return arr;

    }
}
// 54321
// 54312
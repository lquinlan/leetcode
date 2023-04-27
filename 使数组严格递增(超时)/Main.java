import java.lang.reflect.Array;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    int low_bound(int[] arr2,int pre){
        int low =0;
        int high = arr2.length-1;
        // int mid=(low+high)/2;
        while(low<high) { 
            int mid = (low+high)/2;
            if(arr2[mid]>pre){
                high=mid;
            }else { 
                low = mid + 1;
            }

        }
        // 1 4 7
        return low;

    }
    int dfs(int i,int pre,int arr1[],int arr2[]){
        if(i==arr1.length){
            return 0;
        }
        int res=2003;
        int pos=low_bound(arr2,pre);
        if (pos<arr2.length){
            res=dfs(i+1,arr2[pos],arr1,arr2)+1;
        }
        if(arr1[i]>pre){
            res=Math.min(res,dfs(i+1,arr1[i],arr1,arr2));
        }
        return res;
    }
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        int ans=dfs(0,-1, arr1,arr2);

        return ans==2003?-1:ans;

    }
}
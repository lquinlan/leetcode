public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    int[] M=new int[]{0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] praseInt(String str) {
        String[] prase = str.split("-");
        int m=Integer.parseInt(prase[0]);
        int d = Integer.parseInt(prase[1]);
        return new int[]{m,d};

    }
    int[] Satrt(int[] arr1,int[] arr2){
        if(arr1[0]>arr2[0]){
            return arr1;
        }else if(arr1[0]<arr2[0]){
            return arr2;
        }else if (arr1[1] > arr2[1]) {
            return arr1;
        }else{
            return arr2;
        }

    }
    int[] End(int[] arr1,int[] arr2){
        if(arr1[0]>arr2[0]){
            return arr2;
        }else if(arr1[0]<arr2[0]){
            return arr1;
        }else if (arr1[1] > arr2[1]) {
            return arr2;
        }else{
            return arr1;
        }

    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] aliceArr=praseInt(arriveAlice);
        int[] aliceAlea=praseInt(leaveAlice);
        int[] bobArr=praseInt(arriveBob);
        int[] bobAlea=praseInt(leaveBob);
        int[] st=Satrt(aliceArr, bobArr);
        int[] ed=End(aliceAlea, bobAlea);
        if(st[0]>ed[0]||(st[0]==ed[0]&&st[1]>ed[1])){
            return 0;
        }
        int ans=0;
        for(int i=st[0];i<ed[0];++i){
            ans+=M[i];

        }
        ans+=(ed[1]-st[1]+1);
        return ans;


    }
}
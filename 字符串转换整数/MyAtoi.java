public class MyAtoi {
    public static void main(String[] args) {

    }
}

class Solution {
    public int myAtoi(String s) {
        s=s.strip();
        int i=0;
        boolean neg=false;
        if(s.charAt(i)=='-'){
            neg=true;
            ++i;
        }
        Integer.MAX_VALUE;
        Integer.MIN_VALUE;
        int ans=0;
        while(s.charAt(i)<='9'&&s.charAt(i)>='0'&&i<=s.length()){
            int tmp=s.charAt(i)-'0';
            if(neg){
                if(ans<(Integer.MIN_VALUE+tmp)/-10){
                    return INT_MIN_VALUE;
                }else{
                    ans=ans*(-10)-tmp;
                }
            }else{
                if(ans>(Integer.MAX_VALUE-tmp)/10){
                    return Integer.MAX_VALUE;
                }else{
                    ans=ans*10+tmp;
                }
            }

        }
        return ans;

    }
}
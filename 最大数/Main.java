import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String largestNumber(int[] nums) {
      
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, ( a, b) -> {
            int i=0;
            int j=0;
            while(i<a.length() && j<b.length()){
                if(a.charAt(i) == b.charAt(j)){
                    i++;
                    j++;
                }else{
                    return b.charAt(i)-a.charAt(j);
                }
            }
            int tmp=0;
            while(i<a.length()){
                if(a.charAt(i) == b.charAt(tmp)){
                    ++i;
                    tmp=(tmp+1)%b.length();
                }else{
                    return b.charAt(tmp)-a.charAt(i);
                }
            }
            while(j<b.length()){
                if(b.charAt(j) == a.charAt(tmp)){
                    ++j;
                    tmp=(tmp+1)%a.length();
                }else{
                    return b.charAt(j)-a.charAt(tmp);
                }
            }
            return (b+a).compareTo(a+b);
        });
        
        StringBuilder sb = new StringBuilder();
        if(strings[0].equals("0")){
            return "0";
        }
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
        }
        
        return sb.toString();

    }
}
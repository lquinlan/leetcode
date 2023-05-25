
import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public String oddString(String[] words) {
        int[] diff1=diff(words[0]);
        int[] diff2=diff(words[1]);
        if(Arrays.equals(diff1,diff2)){
            for(int i=2;i<words.length;i++){
                if(!Arrays.equals(diff1, diff(words[i]))){
                    return  words[i];
                }
            }

        }else {
            if(Arrays.equals(diff1,diff(words[2]))){
                return words[1];
            }else{
                return words[0];
            }
        }
        return null;


    }
    int[] diff(String str1) {
        int[] tmp=new int[str1.length()-1];
        for(int i=0;i<tmp.length;i++){
            tmp[i]=str1.charAt(i+1)-str1.charAt(i);
        } 
        return tmp;
    }
}
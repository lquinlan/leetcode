public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] map=new int[26];
        for(int i=0;i<s.length(); i++){
            map[s.charAt(i)-'a']=i;
        }
        // int cnt=0;
        for(int i=0;i<s.length();i++){
            if(map[s.charAt(i) - 'a']<=i){
                continue;
            }
            if(map[s.charAt(i) - 'a']-i-1!=distance[s.charAt(i) - 'a']){
                // System.out.println("i=="+i);
                return false;
            }
            
        }
        return true;

    }
}
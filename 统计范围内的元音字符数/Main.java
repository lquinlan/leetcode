public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    // HashSet<Character> set = new HashSet<Character>();
    public int[] vowelStrings(String[] words, int[][] queries) {
        // set.addAll(List.of('a','e','i','o','u'));
        // int[] strtoint=new int[words.length];
       
        int[] presume = new int[words.length+1];
        for(int i=0; i<words.length; i++) {
            presume[i+1]=presume[i]+(check(words[i])?1:0);
        }
     
        int[] ans=new int[queries.length];
        int i=0;
        for(var arr:queries){
            ans[i++]=presume[arr[1]+1]-presume[arr[0]];
        }
        return ans;

    }
    boolean check(String word){
        return isVowelLetter(word.charAt(0)) && isVowelLetter(word.charAt(word.length() - 1));

    }
    public boolean isVowelLetter(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
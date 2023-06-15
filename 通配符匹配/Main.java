public class Main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    Boolean[][] res;
    public boolean isMatch(String s, String p) {
        res=new Boolean[s.length()+1][p.length()+1];
        return dfs(s,p,0,0);

    }
    boolean dfs(String s, String p,int i,int j){
        if(res[i][j]!=null){
            return res[i][j];
        }
        boolean ans;
        if(j==p.length()){
            ans=i==s.length();
        }else if(i==s.length()){
            ans=p.charAt(j)=='*'&&dfs(s,p,i,j+1);
        }else if(p.charAt(j)=='?'||p.charAt(j)==s.charAt(i)){
            ans=dfs(s,p,i+1,j+1);
        }else if(p.charAt(j)=='*'){
            ans=dfs(s,p,i+1,j)||dfs(s,p,i,j+1)||dfs(s,p,i+1,j+1);
        }else{
            ans=false;
        }
        res[i][j]=ans;
        return ans;

    }
}
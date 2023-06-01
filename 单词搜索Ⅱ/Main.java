import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        
    }
}


class Solution {
    TrieNode root=new TrieNode();
    boolean[][] vis;
    List<String> ans=new ArrayList<>();
    int[][] ind=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    int m;
    int n;
    public List<String> findWords(char[][] board, String[] words) {
        for(String word : words){
            insertWord(word);
        }
        m=board.length;
        n=board[0].length;
        vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                vis[i][j]=true;
                dfs(i, j, board, root);
                vis[i][j]=false;
            }
        }
        return ans;

    }
    void dfs(int i,int j,char[][] board,TrieNode root){

        if(root.isEnd){
            root.isEnd=false;
            ans.add(root.end);
        }
        if(root.chilNode[board[i][j]-'a']==null){
            return;
        }
        
        // 
        // System.out.println(board[i][j]);
        // System.out.println("i=="+i+" j=="+j);
       
        for(var in:ind){
            int nx=i+in[0];
            int ny=j+in[1];
            if(nx>=0&&nx<m&&ny>=0&&ny<n&&!vis[nx][ny]){
                vis[nx][ny]=true;
                dfs(nx,ny,board,root.chilNode[board[i][j]-'a']);
                vis[nx][ny]=false;
            }
        }
        if(root.chilNode[board[i][j]-'a'].isEnd){
            root.chilNode[board[i][j]-'a'].isEnd=false;
            ans.add(root.chilNode[board[i][j]-'a'].end);   
        }

    }

    void insertWord(String word){
        var c=word.toCharArray();
        var node=root;
        for(var i:c){
            if(node.chilNode[i-'a']==null){
                node.chilNode[i-'a']=new TrieNode();
            }   
            node=node.chilNode[i-'a'];
        }
        node.isEnd=true;
        node.end=word;
    }

    class TrieNode{
        TrieNode[] chilNode = new TrieNode[26];
        boolean isEnd;
        String end;
    }
}


public class Main{
    public static void main(String[] args) {
        
    }
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();

    }
    
    public void addWord(String word) {
        char[] c = word.toCharArray();
        TrieNode node = root;
        for(var i:c){
            if(node.children[i-'a']==null){
                node.children[i-'a'] = new TrieNode();
            }
            node=node.children[i-'a'];
        }
        node.isEnd = true;

    }
    
    public boolean search(String word) {
        return dfs(word,0,root) ;


    }
    boolean dfs(String word,int index,TrieNode root) {
        if(index==word.length()){
            return root.isEnd;
        }
        char c=word.charAt(index);
        if(c=='.'){
            for(int i=0;i<26;++i){
                if(root.children[i]!=null&&dfs(word,index+1,root.children[i])){
                    return true;
                }
            }
            return false;

        }else{
            if(root.children[c-'a']==null){
                return false;
            }
            return dfs(word,index+1,root.children[c-'a']);
        }

    }
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
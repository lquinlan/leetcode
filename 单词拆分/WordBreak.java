
import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abd";
        List<String> words = new ArrayList<String>();
        words.add("abd");
        // words.add("de");
        solution.wordBreak(s, words);

    }

}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (var i : wordDict) {
            trie.insert(i.toCharArray());
        }
        return trie.find(s.toCharArray(), 0);

    }
}

class Trie {
    TreeNode root = new TreeNode('!');
    boolean[] fail = new boolean[301];

    class TreeNode {
        char val;
        boolean isEnd;
        TreeNode[] children = new TreeNode[26];

        TreeNode(char val) {
            this.val = val;
            isEnd = false;
        }
    }

    void insert(char[] word) {
        TreeNode tmp = root;
        for (int i = 0; i < word.length; i++) {
            int ind = word[i] - 'a';
            if (tmp.children[ind] == null) {
                tmp.children[ind] = new TreeNode(word[i]);
            }
            tmp = tmp.children[ind];
        }
        tmp.isEnd = true;

    }

    boolean find(char[] word, int i) {
        // fail = new boolean[word.length + 1];
        if (fail[i]) {
            return false;
        }
        if (i >= word.length) {
            return true;
        }
        TreeNode tmp = root;
        for (; i < word.length; ++i) {
            int ind = word[i] - 'a';
            if (tmp.children[ind] == null) {
                return false;
            } else {
                tmp = tmp.children[ind];
                if (tmp.isEnd) {
                    if (find(word, i + 1)) {
                        return true;
                    }
                    fail[i + 1] = true;
                }

            }

        }
        return false;
    }
}
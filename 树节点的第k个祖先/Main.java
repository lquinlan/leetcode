import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        
    }
}

class TreeAncestor {
    int[][] lca;

    public TreeAncestor(int n, int[] parent) {
        lca=new int[n][16];
        for (int i=0; i<n; i++){
            Arrays.fill(lca[i], -1);
        }
        for (int i=0; i<n; i++){
            lca[i][0]=parent[i];
        }
        for(int j=1;j<16;++j){
            for(int i=0; i<n; i++){
                if(lca[i][j-1]!=-1){
                    lca[i][j]=lca[lca[i][j-1]][j-1];
                }
            }

        }

    }
    
    public int getKthAncestor(int node, int k) {
        for(int i=0; i<16; i++){
            if(((k>>i)&1)!=0){
                node=lca[node][i];
                if(node==-1){
                    return -1;
                }
            }
        }
        return node;

    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
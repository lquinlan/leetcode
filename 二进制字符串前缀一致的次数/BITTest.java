public class BITTest {
    
}

class BIT{
    int[] Tree;
    int siez;
    BIT(int siez){
        this.siez = siez;
        Tree = new int[siez+1];
    }

    int lowbit(int ind){
        return ind&(-ind);
    }
    void add (int ind,int value){
        while(ind<=siez){
            Tree[ind] += value;
            ind+=lowbit(ind);
        }
    }
    int query(int ind){
        int ans=0;
        while(ind>0){
            ans+=Tree[ind];
            ind-=lowbit(ind);
        }
        return ans;
    }
}

class Solution {
    public int numTimesAllBlue(int[] flips) {
        BIT bit=new BIT(flips.length);
        int ans=0;
        for(int i=0;i<flips.length;++i){
            bit.add(flips[i],1);
            if(bit.query(i+1)==i+1){
                ++ans;
            }
        }
        return ans;

    }
}
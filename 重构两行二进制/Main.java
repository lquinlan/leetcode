import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < colsum.length; i++) {
            res.get(0).add(0);
            res.get(1).add(0);
        }
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                --upper;
                --lower;
                res.get(0).set(i, 1);
                res.get(1).set(i, 1);
                colsum[i]=0;
            }
        }
        int j = 0;

        while (upper > 0 && j < colsum.length) {
            if (res.get(0).get(j) == 0&&colsum[j]==1) {
                res.get(0).set(j, 1);
                --upper;
                colsum[j]=0;
            }
            ++j;
        }

        while (lower > 0 && j < colsum.length) {
            if (res.get(1).get(j) == 0&&colsum[j]==1) {
                res.get(1).set(j, 1);
                --lower;
                colsum[j]=0;
            }
            ++j;
        }
        if(upper!=0||lower!=0){
            return List.of();
        }
        for(var i:colsum){
            if(i!=0){
                return List.of();
            }
        }
        return res;

    }
}
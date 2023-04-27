import java.util.ArrayList;
import java.util.List;

public class MinIndexSum {
    public static void main(String[] args) {

    }
}

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int indexSum = Integer.MAX_VALUE;

        // int index = 0;
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if ((i + j) < indexSum) {
                        indexSum = i + j;
                        // index =i;
                        list.clear();
                        list.add(list1[i]);
                    } else if ((i + j) == indexSum) {
                        list.add(list1[i]);
                    }
                }
                if ((i + j) > indexSum) {
                    break;
                }
            }
        }
        String[] ans = new String[list.size()];
        return list.toArray(ans);

    }
}
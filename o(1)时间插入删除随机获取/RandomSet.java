import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomSet {
    public static void main(String[] args) {

    }
}

class RandomizedSet {
    List<Integer> array = new ArrayList<Integer>();
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    Random random = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        array.add(val);
        map.put(val, array.size() - 1);
        return true;

    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int ind = map.get(val);
            int last = array.get(array.size() - 1);
            array.set(ind, last);
            map.put(last, ind);
            array.remove(array.size() - 1);
            map.remove(val);
            return true;
            //
        }
        return false;

    }

    public int getRandom() {
        int randomIndex = random.nextInt(array.size());
        return array.get(randomIndex);

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
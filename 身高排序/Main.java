
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {

    public String[] sortPeople(String[] names, int[] heights) {

        String[] sortedNames = IntStream.range(0, names.length) // 创建一个包含所有索引的流
                .boxed() // 将int转换为Integer
                .sorted((i, j) -> heights[j] - heights[i]) // 根据heights数组的值降序排序索引
                .map(i -> names[i]) // 将索引映射为对应的名字
                .toArray(String[]::new);
        return sortedNames;

    }
}
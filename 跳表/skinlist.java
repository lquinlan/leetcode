import java.util.Random;

public class SkipList {
    private static final double DEFAULT_PROBABILITY = 0.5;
    private static final int MAX_LEVEL = 16;

    private final Random random = new Random();
    private final Node head = new Node(Integer.MIN_VALUE);
    private int levelCount = 1;
    private double probability = DEFAULT_PROBABILITY;

    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    public void insert(int value) {
        int level = randomLevel();
        Node newNode = new Node(value);
        newNode.maxLevel = level;

        Node[] update = new Node[level];
        for (int i = 0; i < level; ++i) {
            update[i] = head;
        }

        Node p = head;
        for (int i = level - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        for (int i = 0; i < level; ++i) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        if (levelCount < level) {
            levelCount = level;
        }
    }

    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }

            while (levelCount > 1 && head.forwards[levelCount - 1] == null) {
                --levelCount;
            }
        }
    }

    private int randomLevel() {
        int level = 1;
        while (random.nextDouble() < probability && level < MAX_LEVEL) {
            ++level;
        }
        return level;
    }

    private static class Node {
        private final int data;
        private final Node[] forwards;
        private int maxLevel = 0;

        public Node(int data) {
            this.data = data;
            forwards = new Node[MAX_LEVEL];
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", maxLevel=" + maxLevel +
                    '}';
        }
    }
}// 创建跳表对象
SkipList skipList = new SkipList();

// 插入元素
skipList.insert(1);
skipList.insert(2);
skipList.insert(3);

// 查找元素
Node node = skipList.find(2);
System.out.println(node);

// 删除元素
skipList.delete(2);


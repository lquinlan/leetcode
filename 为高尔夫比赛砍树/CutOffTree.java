import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CutOffTree {
    public static void main(String[] args) {

    }
}

class Solution {
    class Node {
        int x, y;
        int value;

        Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public Node getNextNode(PriorityQueue<Node> queue) {
        while (!queue.isEmpty()) {
            Node next = queue.poll();
            if (next.value > 1) {
                return next;
            }
        }
        return null;
    }

    public int cutOffTree(List<List<Integer>> forest) {
        if (forest.get(0).get(0) == 0) {
            return -1;
        }
        PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
            public int compare(Node node1, Node node2) {
                return node1.value - node2.value;
            }

        });
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                queue.add(new Node(i, j, forest.get(i).get(j)));

            }
        }
        int ans = 0;
        Node curind = new Node(0, 0, -1);
        Queue<Node> q1 = new LinkedList<Node>();
        q1.add(curind);
        while (!queue.isEmpty()) {
            Node tmp = getNextNode(queue);
            System.out.println("tmp==" + tmp.x + " " + tmp.y);
            boolean f = false;
            int anstmp = 0;
            int[][] visited = new int[forest.size()][forest.get(0).size()];
            while (!q1.isEmpty()) {
                int len = q1.size();
                for (int i = 0; i < len; ++i) {
                    Node tmp2 = q1.poll();
                    System.out.println("tmp2==" + tmp2.x + " " + tmp2.y);
                    if (tmp2.x == tmp.x && tmp2.y == tmp.y) {
                        q1.clear();
                        q1.add(tmp2);
                        f = true;

                        break;

                    }
                    // ++anstmp;
                    if (tmp2.x >= 1 && forest.get(tmp2.x - 1).get(tmp2.y) >= 1 && visited[tmp2.x - 1][tmp2.y] == 0) {
                        visited[tmp2.x - 1][tmp2.y] = 1;
                        q1.add(new Node(tmp2.x - 1, tmp2.y, -1));
                    }
                    if (tmp2.y >= 1 && forest.get(tmp2.x).get(tmp2.y - 1) >= 1 && visited[tmp2.x][tmp2.y - 1] == 0) {
                        visited[tmp2.x][tmp2.y - 1] = 1;
                        q1.add(new Node(tmp2.x, tmp2.y - 1, -1));
                    }
                    if (tmp2.x < forest.size() - 1 && forest.get(tmp2.x + 1).get(tmp2.y) >= 1
                            && visited[tmp2.x + 1][tmp2.y] == 0) {
                        visited[tmp2.x + 1][tmp2.y] = 1;
                        q1.add(new Node(tmp2.x + 1, tmp2.y, -1));
                    }
                    if (tmp2.y < forest.get(0).size() - 1 && forest.get(tmp2.x).get(tmp2.y + 1) >= 1
                            && visited[tmp2.x][tmp2.y + 1] == 0) {
                        visited[tmp2.x][tmp2.y + 1] = 1;
                        q1.add(new Node(tmp2.x, tmp2.y + 1, -1));
                    }

                }
                System.out.println("f==" + f);
                if (f) {
                    break;
                }
                ++anstmp;
                System.out.println("anstmp==" + anstmp);

            }

            if (f) {
                ans += anstmp;
                f = false;
            } else {
                return -1;
            }

        }

        return ans;

    }
}
// 1 2 3
// 0 0 4
// 7 6 5
import java.util.*;
public class Main2 {
    
}

class Solution {
    class State {
        int playerX;
        int playerY;
        int boxX;
        int boxY;
        int steps;

        public State(int playerX, int playerY, int boxX, int boxY, int steps) {
            this.playerX = playerX;
            this.playerY = playerY;
            this.boxX = boxX;
            this.boxY = boxY;
            this.steps = steps;
        }
                @Override
        public boolean equals(Object obj) {
            State other = (State) obj;
            return playerX == other.playerX && playerY == other.playerY && boxX == other.boxX && boxY == other.boxY;
        }

        // @Override
        // public int hashCode() {
        //     return playerX * 1000000 + playerY * 10000 + boxX * 100 + boxY;
        // }

        @Override
        public int hashCode(){
            return playerX * 1000000 + playerY * 10000 + boxX * 100 + boxY;
        }
  
    }
    boolean isValid(int x, int y, char[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != '#';
    }
    // void dfs(char[][] grid, int x, int y, int steps) {}

    public int minPushBox(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 找到初始位置和目标位置
        int[] player = new int[2];
        int[] box = new int[2];
        int[] target = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    player = new int[]{i, j};
                } else if (grid[i][j] == 'B') {
                    box = new int[]{i, j};
                } else if (grid[i][j] == 'T') {
                    target = new int[]{i, j};
                }
            }
        }

        // 定义四个方向的偏移量
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // 初始状态入队
        State start = new State(player[0], player[1], box[0], box[1], 0);
        Queue<State> queue = new LinkedList<>();
        queue.offer(start);

        // 记录已经访问过的状态
        Set<State> visited = new HashSet<>();
        visited.add(start);

        while (!queue.isEmpty()) {
            State current = queue.poll();

            // 如果当前状态的箱子位置与目标位置相同，直接返回推动次数
            if (current.boxX == target[0] && current.boxY == target[1]) {
                return current.steps;
            }

            // 尝试四个方向的移动
            for (int[] direction : directions) {
                int[] nextPlayerPos = new int[]{current.playerX + direction[0], current.playerY + direction[1]};

                // 如果移动后的位置越界或者是墙，则不能移动
                if (!isValid(nextPlayerPos[0], nextPlayerPos[1], grid)) {
                    continue;
                }

                int[] nextBoxPos = new int[]{current.boxX, current.boxY};

                // 如果移动后的位置与箱子位置相同，则尝试推动箱子
                if (Arrays.equals(nextPlayerPos, nextBoxPos)) {
                    nextBoxPos = new int[]{current.boxX + direction[0], current.boxY + direction[1]};

                    // 如果推动后的箱子位置越界或者是墙，则不能推动
                    if (!isValid(nextBoxPos[0], nextBoxPos[1], grid)) {
                        continue;
                    }

                    // 尝试推动箱子
                    State next = new State(current.boxX, current.boxY, nextBoxPos[0], nextBoxPos[1], current.steps + 1);

                    // 如果新状态已经访问过，则跳过
                    if (visited.contains(next)) {
                        continue;
                    }

                    // 将新状态加入队列和已访问集合
                    queue.offer(next);
                    visited.add(next);
                } else {
                    // 如果移动后的位置不与箱子位置相同，则直接将新状态入队
                    State next = new State(nextPlayerPos[0], nextPlayerPos[1], current.boxX, current.boxY, current.steps);

                    // 如果新状态已经访问过，则跳过
                    if (visited.contains(next)) {
                        continue;
                    }

                    // 将新状态加入队列和已访问集合
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }

        // 如果无法到达目标位置，则返回 -1
        return -1;
    }
}
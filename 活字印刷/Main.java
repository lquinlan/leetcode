import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

    }
}
// 低效版去重

// class Solution {
// Set<String> set = new HashSet<>();
// int[] vis;

// void dfs(String s, StringBuilder sb) {
// if (s.length() == sb.length()) {
// return;
// }

// for (int i = 0; i < s.length(); i++) {
// if (vis[i] == 0) {
// vis[i] = 1;
// sb.append(s.charAt(i));

// String current = sb.toString();
// if (!set.contains(current)) {
// set.add(current);
// dfs(s, sb);
// }

// vis[i] = 0;
// sb.setLength(sb.length() - 1);
// }
// }
// }

// public int numTilePossibilities(String tiles) {
// vis = new int[tiles.length()];
// dfs(tiles, new StringBuilder());
// return set.size();
// }
// }

// 高效版去重

class Solution {
    public int numTilePossibilities(String tiles) {
        int[] vis = new int[26];
        for (int i = 0; i < tiles.length(); i++) {
            vis[tiles.charAt(i) - 'A']++;
        }
        return dfs(vis);

    }

    int dfs(int[] vis){
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (vis[i] > 0) {
                count++;
                vis[i]--;
                count+=dfs(vis);
                vis[i]++;
            }
        }
        return count;
    }

}
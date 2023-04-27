import java.util.Arrays;
import java.util.Comparator;

public class LeastInterval {
    public static void main(String[] args) {
        Solution newSolution = new Solution();
        char[] s = new char[] { 'A', 'A', 'A', 'B', 'B', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K' };

        System.out.println("ans=" + newSolution.leastInterval(s, 7));
    }
}

class Solution {
    count[] map = new count[26];
    int wait = 0;

    class count {
        char val;
        int cnt = 0;
        int nums = 0;

        void setcnt(int n) {
            cnt = n;
        }

        void setval(char val) {
            this.val = val;
        }

        void innums() {
            ++nums;
        }

        void deccnt() {
            --cnt;
        }

        void decnums() {
            --nums;
        }
    }

    char gettask() {
        for (int i = 0; i < 26; ++i) {
            if (map[i].cnt == 0 && map[i].nums > 0) {
                map[i].setcnt(wait);
                map[i].decnums();
                return map[i].val;
            }
        }

        return '-';

    }

    char gettask1() {
        for (int i = 25; i >= 0; --i) {
            if (map[i].cnt == 0 && map[i].nums > 0) {
                map[i].setcnt(wait);
                map[i].decnums();
                return map[i].val;
            }
        }

        return '-';

    }

    void dec(char tasks) {
        for (int i = 0; i < 26; ++i) {
            if (map[i].cnt > 0 && map[i].val != tasks) {
                map[i].deccnt();
            }
        }
    }

    boolean getmax() {

        for (int i = 0; i < 26; ++i) {
            if (map[i].cnt > 0 && map[i].nums > 0) {
                return false;
            } else if (map[i].cnt == 0 && map[i].nums > 0) {
                return true;
            }
        }

        return false;
    }

    public int leastInterval(char[] tasks, int n) {
        wait = n;

        for (int i = 0; i < 26; ++i) {
            map[i] = new count();
            char tmp = (char) ('A' + i);
            map[i].setval(tmp);
        }
        for (var i : tasks) {
            map[i - 'A'].innums();
        }
        Arrays.sort(map, new Comparator<count>() {
            public int compare(count c1, count c2) {
                return c2.nums - c1.nums;

            }
        });
        int ans = 0;
        int len = tasks.length;
        while (len != 0) {

            ans++;
            char tmp;

            if (getmax()) {
                tmp = gettask();

            } else {
                tmp = gettask1();

            }

            if (tmp != '-') {
                --len;
                System.out.println(tmp + "->");
            } else {
                System.out.println("(待命)->");
            }

            dec(tmp);
            Arrays.sort(map, new Comparator<count>() {
                public int compare(count c1, count c2) {
                    if (c2.nums == c1.nums) {
                        return c1.cnt - c2.cnt;
                    } else {
                        return c2.nums - c1.nums;
                    }

                }
            });

        }
        return ans;
    }
}
public class CountStudents {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = { 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1 };
        int[] b = { 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0 };
        solution.countStudents(a, b);

    }
}

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int ql = 0;
        int sl = 0;
        int cnt = 0;
        int len = students.length;
        int cc = 0;
        while (true) {
            ++cc;
            if (sl == sandwiches.length) {
                break;
            }
            if (cnt > len) {
                break;
            }
            while (students[ql] == -1) {
                ++cc;
                ql = (ql + 1) % students.length;

            }
            if (students[ql] == sandwiches[sl]) {
                sl++;
                students[ql] = -1;
                // --len;
                cnt = 0;
            }
            ql = (ql + 1) % students.length;
            ++cnt;

        }
        int ans = 0;
        System.out.println("sl==" + sl);
        for (int i : students) {
            if (i != -1) {
                ++ans;
            }
        }
        System.out.println("ans==" + ans);
        return ans;

    }
}
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int cnt = 0;
        int mas1 = -1;
        int mas2 = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (mas1 == -1) {
                    mas1 = i;
                }
                if (mas2 == -1 && mas1 != i) {
                    mas2 = i;
                    ;
                }
                cnt++;
            }

        }

        if (cnt == 0) {
            return true;
        }
        if ((cnt == 2 && s1.charAt(mas1) == s2.charAt(mas2) && s1.charAt(mas2) == s2.charAt(mas1))) {
            return true;
        } else {
            return false;
        }

    }
}
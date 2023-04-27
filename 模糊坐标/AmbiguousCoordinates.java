import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates {
    public static void main(String[] args) {

    }
}

class Solution {
    List<String> answers = new ArrayList<String>();

    public List<String> ambiguousCoordinates(String s) {
        String ls = s;
        s = ls.substring(1, ls.length() - 1);
        int len = s.length();
        for (int i = 1; i <= len - 1; ++i) {
            List<String> tmp1 = findSolution(s.substring(0, i));
            List<String> tmp2 = findSolution(s.substring(i, len));
            for (int j = 0; j < tmp1.size(); ++j) {
                for (int k = 0; k < tmp2.size(); ++k) {
                    answers.add("(" + tmp1.get(j) + ", " + tmp2.get(k) + ")");
                }
            }

        }

        return answers;

    }

    List<String> findSolution(String s) {
        List<String> tmpanswer = new ArrayList<String>();
        if (s.length() == 1) {
            tmpanswer.add(s);
            return tmpanswer;

        }
        if (s.charAt(0) != '0') {
            tmpanswer.add(s);

        }

        for (int i = 0; i < s.length() - 1; ++i) {
            String tmp = s.substring(0, i + 1) + "." + s.substring(i + 1, s.length());
            if (ischeck(tmp)) {
                tmpanswer.add(tmp);

            }

        }

        return tmpanswer;

    }

    boolean ischeck(String s) {

        int index = s.indexOf('.');

        String sub1 = s.substring(0, index);
        String sub2 = s.substring(index + 1, s.length());
        boolean f1 = true;
        boolean f2 = true;
        if (sub1.length() >= 2 && sub1.charAt(0) == '0') {
            f1 = false;

        }
        if (sub2.charAt(sub2.length() - 1) == '0') {
            f2 = false;
        }
        return f1 && f2;
    }
}

import java.util.HashMap;
import java.util.Iterator;

import java.util.Map;

// import javax.swing.text.html.HTMLDocument.Iterator;

public class MinString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "acbbaca";
        String t = "aba";
        System.out.println(solution.minWindow(s, t));

    }
}

// class Solution {
// Map<Integer, Character> maps;
// Map<Character, Integer> mapt;
// Map<Character, Integer> map1;
// int minl;
// int minr;
// int lastmin;

// // void setMinr

// Solution() {
// maps = new HashMap<Integer, Character>();
// mapt = new HashMap<Character, Integer>();
// map1 = new HashMap<Character, Integer>();
// lastmin = -1;
// // for(int i=0;i<)
// minl = 0;
// minr = Integer.MAX_VALUE;
// }

// void setMap(String k) {
// for (int i = 0; i < k.length(); i++) {
// int l = 0;
// if (mapt.get(k.charAt(i)) != null) {
// l = mapt.get(k.charAt(i)) + 1;
// } else {
// l = 1;
// }
// mapt.put(k.charAt(i), l);
// }
// }

// void countLong() {
// List<Integer> l = new ArrayList<Integer>(maps.keySet());
// // System.out.println(l.toString());
// l.sort(new Comparator<Integer>() {
// public int compare(Integer o1, Integer o2) {
// return o1 - o2;
// }
// });
// int ll = l.get(0);
// int r = l.get(l.size() - 1) + 1;
// if (l.size() > 1) {
// lastmin = l.get(1);
// }

// if ((r - ll) < (minr - minl)) {
// minl = ll;
// minr = r;
// }
// // maps.getKey()
// // maps.remove(maps.getKey(l.get(l.size() - 1)));
// char key = maps.get(ll);
// maps.remove(ll);
// mapt.put(key, 1);

// }

// public String minWindow(String s, String t) {
// if (s.length() < t.length()) {
// return "";
// }
// if (s.length() == t.length() && s.length() == 1) {
// if (s.equals(t)) {
// return s;
// } else {
// return "";
// }
// }
// setMap(t);
// // int minl = 0;
// // int minr = s.length();
// // int l = 0;
// int r = 0;
// int count = 0;
// while (r < s.length()) {
// if (mapt.get(s.charAt(r)) != null) {
// if (mapt.get(s.charAt(r)) > 0) {
// ++count;
// mapt.put(s.charAt(r), mapt.get(s.charAt(r)) - 1);
// map1.put(s.charAt(r), r);

// } else {
// // List<Integer> l = new ArrayList<Integer>(maps.keySet());
// // l.sort(new Comparator<Integer>() {
// // public int compare(Integer o1, Integer o2) {
// // return o1 - o2;
// // }
// // });
// // for (var tmp : l) {
// // if (s.charAt(tmp) == s.charAt(r)) {
// // maps.remove(tmp);
// // break;
// // }
// // }
// if (lastmin != -1) {
// maps.remove(lastmin);
// } else {
// maps.remove(map1.get(s.charAt(r)));
// }

// }
// maps.put(r, s.charAt(r));

// }
// if (count == t.length()) {
// --count;
// countLong();
// }
// ++r;
// }
// // if(minr)
// if (minr != Integer.MAX_VALUE) {
// return s.substring(minl, minr);
// } else {
// return "";
// }

// }
// }

class Solution {
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}

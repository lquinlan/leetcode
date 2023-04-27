public class ToGoatLatin {

    public static void main(String[] args) {

    }
}

class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) == 'a' || words[i].charAt(0) == 'A'
                    || words[i].charAt(0) == 'e' || words[i].charAt(0) == 'E'
                    || words[i].charAt(0) == 'i' || words[i].charAt(0) == 'I'
                    || words[i].charAt(0) == 'o' || words[i].charAt(0) == 'O'
                    || words[i].charAt(0) == 'u' || words[i].charAt(0) == 'U') {
                result.append(words[i]);
                result.append("ma");

            } else {
                result.append(words[i].substring(1, words[i].length()));
                result.append(words[i].charAt(0));
                result.append("ma");
            }
            for (int j = 0; j <= i; ++j) {
                result.append('a');

            }
            if (i != words.length - 1) {
                result.append(' ');
            }

        }
        return result.toString();

    }
}
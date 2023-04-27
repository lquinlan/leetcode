public class Comp {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String ans = solution.complexNumberMultiply("1+-1i", "1+-1i");
        System.out.println(ans);
    }
}

class Solution {
    class Complex {
        int real;
        int virtual;

        int toInt(String num) {
            num = num.split("i")[0];
            int tmp = Integer.parseInt(num);
            // System.out.println(tmp);
            return tmp;
        }

        Complex(String num1) {
            String[] s = num1.split("\\+");
            // System.out.println(s[0]);
            // System.out.println(s[1]);
            real = toInt(s[0]);
            virtual = toInt(s[1]);
        }

        Complex() {
        }

        String mult(Complex num2) {
            Complex num3 = new Complex();
            num3.real = this.real * num2.real - this.virtual * num2.virtual;
            num3.virtual = this.real * num2.virtual + this.virtual * num2.real;

            return num3.toString();
        }

        public String toString() {

            return real + "+" + virtual + "i";
        }
    }

    public String complexNumberMultiply(String num1, String num2) {
        // String num3 = this.mult(num1, num2);
        // System.out.println("com1");
        Complex complex1 = new Complex(num1);
        Complex complex2 = new Complex(num2);
        // System.out.println("com");
        // System.out.println(complex1);
        // System.out.println(complex2);
        // Complex complex3 = new Complex();

        return complex1.mult(complex2);

    }
}
public class DefangIPaddr {
    public static void main(String[] args) {

    }
}

class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");

    }
}
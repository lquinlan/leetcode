import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {
    // private static final Object Integer = null;

    static String formatterPatternSwitch(Object o) {
        return switch (o) {
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case Double d -> String.format("double %f", d);
            case String s -> String.format("String %s", s);
            default -> o.toString();
        };

    }

    public static void main(String[] args) {
        // 控制参数类型,返回不同结果
        String abc = formatterPatternSwitch(9.99);
        System.out.println("abc = " + abc);
    }
}

// public class StreamTest {
// public static void main(String[] args) {
// Address[] addresses = new Address[] { new Address("湖南省", "长沙市", "岳麓区"), new
// Address("湖南省", "长沙市", "雨花区"),
// new Address("湖南省", "永州市", "零陵区"), new Address("湖南省", "永州市", "冷水滩区"), new
// Address("江苏省", "南京市", "建邺区"),
// new Address("江苏省", "南京市", "秦淮区"), new Address("江苏省", "苏州市", "吴江区"), new
// Address("江苏省", "苏州市", "姑苏区"), };
// Map<String, Map<String, List<Address>>> addressGrouping =
// Arrays.stream(addresses)
// .collect(Collectors.groupingBy(Address::province,
// Collectors.groupingBy(Address::city,Collectors.toList())));
// System.out.println(addressGrouping);
// }
// }

// record Address(String province, String city, String district) {
// @Override
// public String province() {
// return province;
// }

// @Override
// public String city() {
// return city;
// }

// @Override
// public String toString() {
// return "Address{" + "province='" + province + '\'' + ", city='" + city + '\''
// + ", district='" + district + '\''
// + '}';
// }
// }
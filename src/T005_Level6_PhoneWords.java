import java.util.HashMap;

public class T005_Level6_PhoneWords {
    public static String phoneWords(String str) {
        HashMap<Integer, String> hMap = new HashMap<>();
        hMap.put(12, "a");
        hMap.put(22, "b");
        hMap.put(32, "c");
        hMap.put(13, "d");
        hMap.put(23, "e");
        hMap.put(33, "f");
        hMap.put(14, "g");
        hMap.put(24, "h");
        hMap.put(34, "i");
        hMap.put(15, "j");
        hMap.put(25, "k");
        hMap.put(35, "l");
        hMap.put(16, "m");
        hMap.put(26, "n");
        hMap.put(36, "o");
        hMap.put(17, "p");
        hMap.put(27, "q");
        hMap.put(37, "r");
        hMap.put(47, "s");
        hMap.put(18, "t");
        hMap.put(28, "u");
        hMap.put(38, "v");
        hMap.put(19, "w");
        hMap.put(29, "x");
        hMap.put(39, "y");
        hMap.put(49, "z");
        hMap.put(10, " ");
        StringBuilder st = new StringBuilder();
        String s;
        int index1;
        int index2 = 1;
        if (str == null) {
            return "";
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            index1 = str.charAt(i) - '0';
            s = hMap.get(index2 * 10 + index1);
            if ((s == null) && (index1 != 1)) {
                return "";
            }
            if (index1 == 1) {
                index2 = 1;
                continue;
            }
            if ((i < length - 1) && (index1 == str.charAt(i + 1) - '0') &&
                    (hMap.get((index2 + 1) * 10 + index1) != null)) {
                index2++;
            } else {
                st.append(s);
                index2 = 1;
            }
        }
        return st.toString();
    }

    public static void main(String[] args) {
        String str = null;
        System.out.println(phoneWords(str));
    }
}

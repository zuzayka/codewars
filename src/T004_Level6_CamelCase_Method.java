public class T004_Level6_CamelCase_Method {
    //change String to StringBuilder
    public static String camelCase(String str) {
        if (str.length() > 0) {
            String[] arr = str.split(" ");
            StringBuilder sbOut = new StringBuilder();
            for (String s : arr) {
                if (s.length() > 0) {
                    sbOut.append(s.substring(0, 1).toUpperCase()).append(s.substring(1));
                }
            }
            return sbOut.toString();
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(camelCase(" a asf"));
    }
}

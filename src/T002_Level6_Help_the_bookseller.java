import java.util.HashMap;

public class T002_Level6_Help_the_bookseller {
    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        int booksQuantity = 0;
        String result = "";
        if (lstOfArt == null) {
            return result;
        }
        HashMap<Character, Integer> catalog = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            catalog.put(c, 0);
        }
        for (int i = 0; i < 26; i++) {
            for (String s : lstOfArt) {
                if ((s.length() < 3) || (s.charAt(0) < 'A') || (s.charAt(0) > 'Z')) {
                    return result;
                }
                char ch = (char) ('A' + i);
                Character chr = ch;
                if (s.charAt(0) == ch) {
                    String[] tempArr = s.split(" ");
                    if ((tempArr.length != 2) || (!isNumeric(tempArr[1]))) {
                        return result;
                    }
                    Integer valueHM = catalog.get(chr);
                    valueHM += Integer.parseInt(tempArr[1]);
                    catalog.put(chr, valueHM);
                }
            }
        }

        int lengthLetters = lstOf1stLetter.length;
        if (lengthLetters != 0) {
            for (int i = 0; i < lengthLetters; i++) {
                if ((lstOf1stLetter[i].charAt(0) < 'A') || (lstOf1stLetter[i].charAt(0) > 'Z')) {
                    return  result;
                }
                booksQuantity += catalog.get(lstOf1stLetter[i].charAt(0));
                result = result.concat("(" + lstOf1stLetter[i] + " : " + catalog.get(lstOf1stLetter[i].charAt(0)) + ")");
                if (lengthLetters - i > 1) {
                    result = result.concat(" - ");
                }
            }
        }
        System.out.println(booksQuantity);
        if (booksQuantity == 0) {
            return "";
        }
        return result;
    }

    public static boolean isNumeric(String string) {
        int intValue;
        if(string == null || string.equals("")) {
            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }
        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }

    public static void main(String[] args) {
        String[] s1 = {"ABAR 000", "CDXE 500", "BKWR 000", "BTSQ 000", "DRTY 600"};
        String[] s2 = {"A", "B"};
        System.out.println(stockSummary(s1, s2));
    }
}

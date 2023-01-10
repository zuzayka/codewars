import java.util.ArrayList;

public class T007_SimplePigLatin {
    public static String pigIt(String str) {
        if (str.equals("")) {
            return "ay";
        }
        char[] cArr = str.toCharArray();
        int length = cArr.length;
        ArrayList<Character> aLChars = new ArrayList<>();
        StringBuilder pigSB = new StringBuilder();
        for (int i = 0; i < length; i++) {
            aLChars.clear();
            StringBuilder temp = new StringBuilder();
            if (!Character.isLetter(cArr[i])) {
                temp.append(cArr[i]);
                System.out.println(temp);
            } else {
                while (Character.isLetter(cArr[i]) && (i < length - 1)) {
                    aLChars.add(cArr[i]);
                    if (i < length - 1) {
                        i++;
                    }
                }
                if (i < length - 1) {
                    i--;
                } else {
                    aLChars.add(cArr[i]);
                }
                char first = aLChars.get(0);
                System.out.println(aLChars);
                aLChars.remove(0);
                for (Character c : aLChars) {
                    temp.append(c);
                }
                temp.append(first).append("ay");
            }
            pigSB.append(temp);
        }
        return String.valueOf(pigSB);
    }

    public static void main(String[] args) {
        System.out.println(pigIt("O tempora o mores4"));
    }
}

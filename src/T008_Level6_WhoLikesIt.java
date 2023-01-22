public class T008_Level6_WhoLikesIt {
    public static String whoLikesIt(String... names) {
        String temp;
        int length = names.length;
        String additive1 = " likes this";
        String additive2 = " like this";
        if (length == 1) {
            temp = names[0] + additive1;
        } else if (length == 2) {
            temp = names[0] + " and " + names[1] + additive2;
        } else if (length == 3) {
            temp = names[0] + ", " + names[1] + " and " + names[2] + additive2;
        } else if (length > 3) {
            temp = names[0] + ", " + names[1] + " and " + (length - 2) + " others" + additive2;
        } else {
            temp = "no one" + additive1;
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }
}

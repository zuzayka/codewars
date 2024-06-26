public class T010_Level5_GreedIsGood {
    public static int result(int[] rollArray) {
        int[] countArray = new int[6];
        for (int i = 0; i < rollArray.length; i++) {
            switch (rollArray[i]) {
                case(1):
                    countArray[0]++;
                    break;
                case(2):
                    countArray[1]++;
                    break;
                case(3):
                    countArray[2]++;
                    break;
                case(4):
                    countArray[3]++;
                    break;
                case(5):
                    countArray[4]++;
                    break;
                case(6):
                    countArray[5]++;
                    break;
                default:
                    break;
            }
        }
        return  countArray[0] / 3 * 1000 + ((countArray[0] % 3) * 100) + (countArray[1] / 3 * 200) +
             (countArray[2] / 3 * 300) + (countArray[3] / 3 * 400) + (countArray[4] / 3 * 500) +
             ((countArray[4] % 3) * 50) + countArray[5] / 3 * 600;
    }

}

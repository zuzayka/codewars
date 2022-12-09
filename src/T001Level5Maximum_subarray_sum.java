import java.util.ArrayList;
import java.util.Arrays;

public class T001Level5Maximum_subarray_sum {
    public static int sequence(int[] arr) {
        if (arr.length > 0) {
            int length = arr.length;
            int[] arrSorted = arr.clone();
            Arrays.sort(arrSorted);
            if (arrSorted[length - 1] <= 0) {
                return 0;
            }
        } else {
            return 0;
        }
        ArrayList<Integer> aL = new ArrayList<>();
        for (int i : arr) {
            aL.add(i);
        }
        int size = aL.size();
        int k = 0;
        while (true) {
            if (aL.get(k) < 0) {
                aL.set(k, 0);
                k++;
            } else {
                break;
            }
        }
        k = size - 1;
        while (true) {
            if (aL.get(k) < 0) {
                aL.set(k, 0);
                k--;
            } else {
                break;
            }
        }
        ArrayList<Integer> tempAL = new ArrayList<>();
        int ad = 0;
        int mi = 0;
        for (int i = 0; i < size; i++) {
            if (aL.get(i) >= 0) {
                ad += aL.get(i);
                mi = 0;
                if ((i == size - 1) || (aL.get(i + 1) < 0)) {
                    tempAL.add(ad);
                }
            }
            if (aL.get(i) < 0) {
                mi += aL.get(i);
                ad = 0;
                if ((aL.get(i + 1) >= 0)) {
                    tempAL.add(mi);
                }
            }
        }
        int sizeT = tempAL.size();
        if (sizeT == 1) {
            if (tempAL.get(0) > 0) {
                return tempAL.get(0);
            } else {
                return 0;
            }
        }
        int max = tempAL.get(0);
        for (int j = 0; j < sizeT; ) {
            int indexF = j;
            for (int i = j; i < sizeT; ) {
                int temp = 0;
                for (int m = j; m <= indexF; m++) {
                    temp += tempAL.get(m);
                }
                if (max < temp) {
                    max = temp;
                }
                indexF += 2;
                i += 2;
            }
            j += 2;
        }
        return Math.max(max, 0);
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, -5};
        System.out.println(sequence(arr));
    }
}
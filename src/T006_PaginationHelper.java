import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T006_PaginationHelper<E> {
    public int items;
    public List<E> eL;

    public T006_PaginationHelper(List<E> eL, int items) {
        this.items = items;
        this.eL = eL;
    }


    public ArrayList<ArrayList<E>> eLSort (List<E> eL, int item) {
        if ((eL == null) || (item <= 0)) {
            return null;
        }
        int length = eL.size();
        ArrayList<ArrayList<E>> eLSorted = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            ArrayList<E> itemAL = new ArrayList<>();
            for (int j = 0; j < items; j++) {
                itemAL.add(eL.get(i));
                if (j < items - 1) {
                    i++;
                }
                System.out.println(itemAL);
                if (i >= length) {
                    break;
                }
            }
            System.out.println(itemAL + " itemAL");
            eLSorted.add(itemAL);
        }
        return eLSorted;
    }

    public int pageCount(){
        int length = eL.size();
        if (length == 0) {
            return 0;
        } else if (length % items == 0){
            return length / items;
        } else{
            return length / items + 1;
        }
    }

    public int itemCount() {
        if (eL == null) {
            return -1;
        }
        return eL.size();
    }

    public int pageItemCount(int pageNum) {
        int bookLength = eLSort(eL,items).size();
        if ((pageNum < 0) || (pageNum >= bookLength)) {
            System.out.println(bookLength + " bookLength " + items + " items " + eL + " eL");
            return -1;
        } else {
            System.out.println(eLSort(eL, items).get(pageNum) + " " + pageNum);
            return eLSort(eL,items).get(pageNum).size();
        }
    }

    public int pageIndex(int index) {
        int length = eL.size();
        if ((index < 0) || index >= length) {
            return  -1;
        }
        return  index / items;
    }
}

class Main {
    public static void main(String[] args) {
        T006_PaginationHelper<Character> helper = new T006_PaginationHelper( Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        System.out.println(helper.pageCount());
        System.out.println(helper.itemCount());
        System.out.println(helper.pageItemCount(1));
        System.out.println(helper.pageIndex(-1));
    }
}

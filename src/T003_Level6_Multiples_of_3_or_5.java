public class T003_Level6_Multiples_of_3_or_5 {
    public int solution(int number) {
        int sum = 0;
        int i = 1;
        while (i < number) {
            if ((i % 3 == 0) || (i % 5 == 0)) {
                sum += i;
            }
            i++;
        }
        return  sum;
    }

    public static void main(String[] args) {
        T003_Level6_Multiples_of_3_or_5 t = new T003_Level6_Multiples_of_3_or_5();
        System.out.println(t.solution(10));
    }
}

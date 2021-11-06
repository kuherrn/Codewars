import java.util.ArrayList;

class Persist {

    private static int counter = 0;

    public static int persistence(long n) {
        long myNum = 1;
        ArrayList<Long> myArray = new ArrayList<>();

        if (n >= 10) {
            while (n > 0) {
                myArray.add(n % 10);
                n /= 10;
            }
            for (Long el : myArray) {
                myNum *= el;
            }
            counter++;
            persistence(myNum);
        }
        return counter;
    }
}

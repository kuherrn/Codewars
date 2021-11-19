// Maintain two array lists.
// Push the division of each int into their respective array lists until the int = 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HammingDistance {
    public static int hammingDistance (int x, int y) {
        int diff = 0;
        List<Integer> numX = getBinary(x);
        List<Integer> numY = getBinary(y);

        int biggerArray = Math.max(numX.size(), numY.size());
        int smallerArray = Math.min(numX.size(), numY.size());
        int sizeDiff = biggerArray - smallerArray;

        if(numX.size() > numY.size()) {
            while (sizeDiff > 0) {
                numY.add(0);
                sizeDiff--;
            }
        } else if (numX.size() < numY.size()) {
            while (sizeDiff > 0) {
                numX.add(0);
                sizeDiff--;
            }
        }

        while (biggerArray > 0) {
            if (numX.get(biggerArray - 1) != numY.get(biggerArray - 1)) diff++;
            biggerArray--;
        }

        return diff;
    }

    private static ArrayList<Integer> getBinary (int num) {
        ArrayList<Integer> myArray = new ArrayList<>();
        while (num > 0) {
            myArray.add(num % 2);
            num /= 2;
        }
        return myArray;
    }
}
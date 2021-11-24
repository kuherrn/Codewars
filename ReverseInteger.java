
// https://leetcode.com/problems/reverse-integer/submissions/

import java.util.ArrayList;

class ReverseInteger {
    public static int reverse(int x) {
        long result = 0;

        int positive = x < 0 ? x * -1 : x;

        ArrayList<Integer> myArray = new ArrayList<>();
        while (positive > 0) {
            myArray.add(positive % 10);
            positive /= 10;
        }

        int [] reverseNum = myArray.stream().mapToInt(i -> i).toArray();
        for (int i = 0; i < reverseNum.length; i++) {
            result = result * 10 + reverseNum[i];
        }

        System.out.println(result);
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
        return x < 0 ? (int) result * -1 : (int) result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}

/* Constant time solution
    public static int reverse(Integer x) {
        if (x >= 0) {
            return reverseString(x.toString().replace('-', ' '));
        } else {
            return reverseString(x.toString().substring(1)) * -1;
        }
    }

    private static int reverseString(String toString) {
        StringBuilder builder = new StringBuilder(toString);
        builder.reverse();
        try {
            int k = Integer.parseInt(builder.toString());
            return k;
        } catch (Throwable e) {
            return 0;
        }
    }
*/
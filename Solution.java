// https://www.codewars.com/kata/5208f99aee097e6552000148/train/java

import java.util.Arrays;

class Solution {
    public static String camelCase(String input) {
        return String.join(" ", input.split("(?=\\p{Upper})"));

    }
}

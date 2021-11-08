import java.util.Arrays;

class Solution {
    public static String camelCase(String input) {
        return String.join(" ", input.split("(?=\\p{Upper})"));

    }
}
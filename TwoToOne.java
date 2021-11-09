
//https://www.codewars.com/kata/5656b6906de340bd1b0000ac/train/java
//Core Code: https://stackoverflow.com/questions/4989091/removing-duplicates-from-a-string-in-java

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

class TwoToOne {
    public static String longest (String s1, String s2) {

        String myString = s1 + s2;
        char[] myArray = myString.toCharArray();
        Arrays.sort(myArray);
        Set<Character> charSet = new LinkedHashSet<>();
        for (char myChar : myArray) {
            charSet.add(myChar);
        }

        StringBuilder sb = new StringBuilder();
        for(Character c : charSet) {
            sb.append(c);
        }

        return sb.toString();
    }
}

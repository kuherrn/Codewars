// https://leetcode.com/problems/longest-palindromic-substring/submissions/
// Cubic runtime

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class LongestPalindromicSubstring {
    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            for (int j  = s.length() - (i + 1); j >= s.length() / 2;) {
                if (s.charAt(i) == s.charAt(j)) break;
                return false;
            }
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        if (s.length() == 1 || s.length() == 2 && s.charAt(0) != s.charAt(1)) return "" + s.charAt(0);
        if (s.charAt(0) == s.charAt(1) && s.length() == 2) return s.substring(0, 2);
        ArrayList<String> myList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isPalindrome(s.substring(i, j+1))) myList.add(s.substring(i, j+1));
            }
        }

        try {
            return Collections.max(myList, Comparator.comparing(String::length));
        } catch (Exception e) {
            return "" + s.charAt(0);
        }
    }
    
}
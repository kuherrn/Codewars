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

/*
n^2 time complexity solution from Leetcode

1. Loop through the array of strings.
2. During each iteration, expand a window from the middle checking for
    - charAt equals a left and right pointer
3. Return the length of the longest palindrome for the iteration
4. If the length is greater than the current end-start index
    - update the start index and end index of the substring 
5. Return the substring

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
*/
    

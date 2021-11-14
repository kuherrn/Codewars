// https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/


import java.util.HashSet;


class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int myChar = 0;
        int window = 0;
        int max = 0;

        HashSet<Character> myHashSet = new HashSet<>();

        while (window < s.length()) {
            if (!myHashSet.contains(s.charAt(window))) {
                myHashSet.add(s.charAt(window));
                window++;
                max = Math.max(myHashSet.size(), max);
            } else {
                myHashSet.remove(s.charAt(myChar));
                myChar++;
            }
        }
        return max;
    }
}

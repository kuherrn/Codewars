// https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/


import java.util.HashSet;


class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int myChar = 0;
        int max = 0;

        HashSet<Character> myHashSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (!myHashSet.contains(s.charAt(i))) {
                myHashSet.add(s.charAt(i));
                max = Math.max(myHashSet.size(), max);
            } else {
                myHashSet.remove(s.charAt(myChar));
                myChar++;
            }
        }

        return max;

    }

}
package main.java;

public class LongestCommonPrefix14 {
    /**
     * Write a function to find the longest common prefix string
     * amongst an array of strings.
     *
     * If there is no common prefix, return an empty string "".
     *
     *
     *
     * Example 1:
     *
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     *
     * Input: strs = ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     *
     *
     * Constraints:
     *
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] consists of only lower-case English letters.
     */

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder res = new StringBuilder();

            if (strs == null || strs.length == 0) {
                return res.toString();
            }

            Arrays.sort(strs, Comparator.comparing(String::length));
            int minLen = strs[0].length();

            for (int i = 0; i < minLen; i++) {
                char current = strs[0].charAt(i);
                for (String str : strs) {
                    if (str.charAt(i) != current) {
                        return res.toString();
                    }
                }
                res.append(current);
            }
            return res.toString();
        }
    }

}

/**
 * 19 ms	35 MB
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1 || new StringBuilder(s).reverse().toString().equals(s)) {
            return s;
        }
        int startIndex = 0, endIndex = 0, maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= Math.min(i, s.length() - i - 1); j++) {
                if (s.charAt(i - j) != s.charAt(i + j)) {
                    break;
                }
                if (2*j > maxLength) {
                    startIndex = i - j;
                    endIndex = i + j;
                    maxLength = 2*j;
                }
            }
            for(int j = 0; j <= Math.min(i, s.length() - i - 2); j++) {
                if (s.charAt(i - j) != s.charAt(i + j + 1)) {
                    break;
                }
                if (2*j + 1 > maxLength) {
                    startIndex = i - j;
                    endIndex = i + j + 1;
                    maxLength = 2*j + 1;
                }
            }
        }
        if (endIndex == s.length() - 1) {
            return s.substring(startIndex);
        }
        return s.substring(startIndex, endIndex + 1);
    }
}

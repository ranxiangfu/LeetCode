/**
 * 6 ms	39.1 MB
 */
class Solution {
    
    public int strStr2(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        for (int i = 0; i < h.length; i++) {
            if (check(h, n, i)) {
                return i;
            }
        }
        return -1;
    }

    public boolean check(char[] h, char[] n, int index) {
        for (int i = 0; i < n.length; i++) {
            if (i + index >= h.length || h[i + index] != n[i]) {
                return false;
            }
        }
        return true;
    }
}

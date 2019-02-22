/**
 * 23 ms	39.8 MB
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxSubStrLength = 0, i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            Character c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                j ++;
                maxSubStrLength = maxSubStrLength >= j - i ? maxSubStrLength : j - i;
            } else {
                // 移除重复字符前的所有字符,j未动
                set.remove(s.charAt(i));
                i ++;
            }
        }
        return maxSubStrLength;
    }
}

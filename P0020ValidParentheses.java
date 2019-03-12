/**
 * 4 ms	37.1 MB
 */
class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.length()%2 != 0) {
            return false;
        }
        List<Character> left = new ArrayList<>(Arrays.asList('(', '{', '['));
        List<Character> right = new ArrayList<>(Arrays.asList(')', '}', ']'));
        Stack<Character> lrStack = new Stack<>();
        for (int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            int ci = left.indexOf(c);
            if (ci >= 0) {
                lrStack.push(right.get(ci));
                continue;
            }
            if (lrStack.isEmpty() || c != lrStack.pop()) {
                return false;
            }
        }
        return lrStack.isEmpty();
    }
}

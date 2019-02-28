/**
 * 79 ms	40.6 MB
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int revNum;
        try {
            revNum = Integer.parseInt(new StringBuilder().append(x).reverse().toString());
        } catch (NumberFormatException e) {
            return false;
        }
        if (revNum == x) {
            return true;
        }
        return false;
    }
}

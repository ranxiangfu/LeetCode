/**
 * 15 ms	38 MB
 */
class Solution {
    public int reverse(int x) {
        if (x > -10 && x < 10) {
            return x;
        }
        boolean isNegativeNumber = false;
        if (x < 0) {
            isNegativeNumber = true;
            x = -x;
        }
        String reverseStr = new StringBuilder(String.valueOf(x)).reverse().toString();
        while (reverseStr.startsWith("0")) {
            reverseStr = reverseStr.substring(1);
        }
        if (isNegativeNumber) {
            reverseStr = "-" + reverseStr;
        }
        int num = 0;
        try {
            num = Integer.parseInt(reverseStr);
        } catch (NumberFormatException e) {}
        return num;
    }
}

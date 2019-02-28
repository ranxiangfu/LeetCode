/**
 * 17 ms	38.5 MB
 */
class Solution {
    public int myAtoi(String str) {
        // 先去除两边空格再判断是否为空串
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        // 判断是否为负数并去除+-符号
        boolean isNegativeNumber = false;
        if (str.startsWith("-")) {
            isNegativeNumber = true;
            str = str.substring(1);
        } else if (str.startsWith("+")) {
            str = str.substring(1);
        }
        // 去除+-符号后再次判断是否为空串
        if (str.length() == 0) {
            return 0;
        }
        // 逐个字符判断是否为数字并记录第一个不是数字的字符下标
        int endIndex =  str.length();
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                endIndex = i;
                break;
            }
        }
        // 如果首字符不是数字直接返回0
        if (endIndex == 0) {
            return 0;
        }
        // 负数加上-符号再尝试转换为int
        str = str.substring(0, endIndex);
        if (isNegativeNumber) {
            str = "-" + str;
        }
        int num = 0;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            if (isNegativeNumber) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        return num;
    }
}

/**
 * 35 ms	39.4 MB
 */
class Solution {
    public int romanToInt(String s) {
        // Map<String, Integer> romanIntMap = new HashMap<>(16);
        // romanIntMap.put("I", 1);
        // romanIntMap.put("V", 5);
        // romanIntMap.put("X", 10);
        // romanIntMap.put("L", 50);
        // romanIntMap.put("C", 100);
        // romanIntMap.put("D", 500);
        // romanIntMap.put("M", 1000);
        // romanIntMap.put("IV", 4);
        // romanIntMap.put("IX", 9);
        // romanIntMap.put("XL", 40);
        // romanIntMap.put("XC", 90);
        // romanIntMap.put("CD", 400);
        // romanIntMap.put("CM", 900);
        int ans = 0;
        for (int i = 0; i< s.length(); i++) {
            if (i + 1 < s.length()) {
                // Integer v = romanIntMap.get(s.substring(i, i+2));
                Integer v = getValue(s.substring(i, i+2));
                if (v != null) {
                    ans += v;
                    i = i + 1;
                    continue;
                }
            }
            // ans += romanIntMap.get(s.substring(i, i+1));
            ans += getValue(s.substring(i, i+1));
        }
        return ans;
    }
    
    public Integer getValue(String sub) {
        switch (sub) {
            case "I" : return 1;
            case "V" : return 5;
            case "X" : return 10;
            case "L" : return 50;
            case "C" : return 100;
            case "D" : return 500;
            case "M" : return 1000;
            case "IV" : return 4;
            case "IX" : return 9;
            case "XL" : return 40;
            case "XC" : return 90;
            case "CD" : return 400;
            case "CM" : return 900;
            default: return null;
        }
    }
}

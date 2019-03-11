/**
 * 1 ms	37.3 MB
 */
class Solution {
    Map<String, String> map = new HashMap<String, String>();
    List<String> ans = new ArrayList<String>();
    
    public List<String> letterCombinations(String digits) {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        if (!digits.isEmpty()) {
            backtrack("", digits);
        }
        return ans;
    }

    public void backtrack(String combination, String next_digits) {
        // 递归完毕将字符串放入list
        if (next_digits.isEmpty()) {
            ans.add(combination);
            return;
        }
        // 循环递归
        String digit = next_digits.substring(0, 1);
        String letters = map.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            String letter = map.get(digit).substring(i, i + 1);
            backtrack(combination + letter, next_digits.substring(1));
        }
    }


}

/**
 * 1 ms	37.9 MB
 */
class Solution {
    List<String> ans = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        track(0, 0, n, "");
        return ans;
    }

    public void track(int leftCount, int rightCount, int n, String s) {
        if (leftCount == n && rightCount == n) {
            ans.add(s);
        }
        if (leftCount < n) {
            track(leftCount + 1, rightCount, n, s + "(");
        }
        if (rightCount < n && rightCount < leftCount) {
            track(leftCount, rightCount + 1, n, s + ")");
        }
    }
}

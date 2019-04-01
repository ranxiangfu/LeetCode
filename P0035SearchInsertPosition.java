/**
 * 2 ms	39.8 MB
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (l == r - 1 || l == r) {
                return r;
            }
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return 0;
    }
}

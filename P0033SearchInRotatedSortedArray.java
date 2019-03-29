/**
 * 5 ms	39.6 MB
 */
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        return find(nums, 0, nums.length - 1, target);
    }
    
    public int find (int[] nums, int l, int r, int target) {
        if (r >= nums.length || l < 0) {
            return -1;
        }
        if (l == r - 1) {
            if (nums[l] == target) {
                return l;
            }
            if (nums[r] == target) {
                return r;
            }
            return -1;
        } else if (l == r) {
            return nums[l] == target ? l : -1;
        }
        int mid = l + (r - l)/2;
        if (nums[mid] == target) {
            return mid;
        } else if (target < nums[mid]) {
            if (nums[mid] < nums[0]) {
                return find(nums, l, mid, target);
            } else {
                if (target >= nums[0]) {
                    return find(nums, l, mid, target);
                } else {
                    return find(nums, mid, r, target);
                }
            }
        } else {
            if (nums[mid] > nums[0]) {
                return find(nums, mid, r, target);
            } else {
                if (target >= nums[0]) {
                    return find(nums, l, mid, target);
                } else {
                    return find(nums, mid, r, target);
                }
            }
        }
    }
}

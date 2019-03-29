/**
 * 3 ms	42.4 MB
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int index = find(nums, 0, nums.length-1, target);
        if (index == -1) {
            return new int[]{-1, -1};
        } else {
            int fir = index;
            int las = index;
            while(fir > 0) {
                if (nums[index] == nums[fir - 1]) {
                    fir --;
                    continue;
                }
                break;
            }
            while (las < nums.length - 1) {
                if (nums[index] == nums[las + 1]) {
                    las ++;
                    continue;
                }
                break;
            }
            return new int[]{fir, las};
        }
    }
    public int find(int[] nums, int l, int r, int target) {
        if (l < 0 || r >= nums.length) {
            return -1;
        }
        if (l == r - 1 || l == r) {
            if (nums[l] == target) {
                return l;
            }
            if (nums[r] == target) {
                return r;
            }
            return -1;
        }
        int mid = l + (r - l)/2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return find(nums, l, mid, target);
        } else {
            return find(nums, mid, r, target);
        }
    }
}

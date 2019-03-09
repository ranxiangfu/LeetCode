/**
 * 7 ms	40 MB
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int gap = Integer.MAX_VALUE; 
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lo = i+1, ri = nums.length - 1;
            while (lo < ri) {
                int sum = nums[lo] + nums[ri] + nums[i];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    if (target - sum < gap) {
                        gap = target - sum;
                        ans = sum;
                    }
                    while (lo < ri && nums[lo] == nums[lo+1]) {
                        lo++;
                    }
                    lo++;
                } else {
                    if (sum - target < gap) {
                        gap = sum - target;
                        ans = sum;
                    }
                    while (lo < ri && nums[ri] == nums[ri-1]) {
                        ri--;
                    }
                    ri--;
                }
            }
        }
        return ans;
    }

}

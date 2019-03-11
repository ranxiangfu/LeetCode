/**
 * 27 ms	39.5 MB
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int lo = j + 1, ri = nums.length - 1, sum = target - nums[i] - nums[j];
                while (lo < ri) {
                    if (nums[lo] + nums[ri] == sum) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[ri]));
                        while (lo < ri && nums[lo] == nums[lo+1]) {
                            lo++;
                        }
                        while (lo < ri && nums[ri] == nums[ri-1]) {
                            ri--;
                        }
                        lo++;
                        ri--;
                    } else if (nums[lo] + nums[ri] > sum) {
                        ri--;
                    } else {
                        lo++;
                    }
                }
            }
        }
        return ans;
    }
}

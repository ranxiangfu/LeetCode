/**
 * 37 ms	48.9 MB
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
                Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                // 过滤重复的值
                continue;
            }
            // 两侧往中间移动,类似于装最多水那题的想法
            int lo = i+1, hi = nums.length-1, sum = 0 - nums[i];
            while (lo < hi) {
                if (nums[lo] + nums[hi] == sum) {
                    ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo+1]){
                        lo++;
                    }
                    while (lo < hi && nums[hi] == nums[hi-1]) {
                        hi--;
                    }
                    lo++; hi--;
                } else if (nums[lo] + nums[hi] < sum) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return ans;
    }
    
}

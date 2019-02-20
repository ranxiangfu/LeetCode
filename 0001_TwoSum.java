/**
 * 144 ms
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i<nums.length; i++){
            for(int j =0; j<nums.length; j++){
                if(i == j){
                    continue;
                }
                if(target == nums[i] + nums[j]){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}

/**
 * 间距缩小的同时想要面积增大，min是阻碍，所以移动短边.
 * 4 ms	40.5 MB
 */
class Solution {
    public int maxArea(int[] height) {
        int max = 0, lIndex = 0, rIndex = height.length - 1;
        while (lIndex < rIndex) {
            int v = (rIndex - lIndex) * Math.min(height[lIndex], height[rIndex]);
            max = Math.max(max, v);
            if (height[lIndex] < height[rIndex]) {
                lIndex++;
            } else {
                rIndex--;
            }
        }
        return max;
    }
}

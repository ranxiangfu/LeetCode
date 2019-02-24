/**
 * 36 ms	49.1 MB
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>(nums1.length + nums2.length);
        // jdk8
        // list.addAll(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
        // list.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        for (int num : nums1) {
            list.add(num);
        }
        for (int num : nums2) {
            list.add(num);
        }
        if (list.size() == 1) {
            return list.get(0); 
        }
        Collections.sort(list);
        if (list.size() % 2 == 0) {
            return (list.get(list.size()/2) + list.get(list.size()/2 - 1))/2.0;
        } else {
            return list.get(list.size()/2);
        }
    }
}

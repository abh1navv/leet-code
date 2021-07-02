class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int x=0;
        for(int i:nums2) {
            nums1[m+x++] = i;
        }
        Arrays.sort(nums1);
    }
}
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> duplicateSet = new HashSet<>();
                Set<Integer> secondSet = new HashSet<>();

        
        List<List<Integer>> ans = new ArrayList<>();

        for(int num: nums1) {
            firstSet.add(num);
        }
        
        for(int num:nums2) {
            if(firstSet.contains(num)) {
                firstSet.remove(num);
                duplicateSet.add(num);
            } else if(!duplicateSet.contains(num)) {
                secondSet.add(num);
            }
        }
        
        ans.add(new ArrayList<>(firstSet));
        ans.add(new ArrayList<>(secondSet));
        
        return ans;
    }
}
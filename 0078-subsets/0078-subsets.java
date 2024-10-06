class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        ans.add(new ArrayList<>());

        findSubsets(ans, new ArrayList<>(), nums, 0);
        
        return new ArrayList<>(ans);
    }
    
    void findSubsets(Set<List<Integer>> ans, List<Integer> curr, int[] nums, int index) {
        
        if(curr.size() == nums.length) return;
        
        for(int i=index; i<nums.length; i++) {
            if(!curr.contains(nums[i])) {
                curr.add(nums[i]);
                ans.add(new ArrayList<>(curr));

                findSubsets(ans, curr, nums, i);
                curr.remove(curr.size()-1);
            }
        }
    }
}
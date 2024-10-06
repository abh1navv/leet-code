class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(ans, new HashSet<>(), nums, 0);
        
        return ans;
    }
    
    void findSubsets(List<List<Integer>> ans, Set<Integer> curr, int[] nums, int index) {
        ans.add(new ArrayList<>(curr));

        for(int i=index; i<nums.length; i++) {
            if(curr.add(nums[i])) {
                curr.add(nums[i]);
                findSubsets(ans, curr, nums, i);
                curr.remove(nums[i]);
            }
        }
    }
}
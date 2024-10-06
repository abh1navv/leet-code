class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(ans, new LinkedHashSet<>(), nums);
        
        return ans;
    }
    
    void findSubsets(List<List<Integer>> ans, Set<Integer> curr, int[] nums) {
        if(curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        } 

        for(int i=0; i<nums.length; i++) {
            if(curr.add(nums[i])){
                findSubsets(ans, curr, nums);
                curr.remove(nums[i]);
            }
        }
    }
}
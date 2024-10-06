class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(ans, new ArrayList<>(), nums);
        
        return ans;
    }
    
    void findSubsets(List<List<Integer>> ans, List<Integer> curr, int[] nums) {
        if(curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        } 

        for(int i=0; i<nums.length; i++) {
            if(!curr.contains(nums[i])){
                curr.add(nums[i]);
                findSubsets(ans, curr, nums);
                curr.remove(curr.size()-1);
            }
        }
    }
}
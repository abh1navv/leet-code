class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        findSubsets(ans, new ArrayList<>(), nums, 0);
        
        return ans;
    }
    
    void findSubsets(List<List<Integer>> ans, List<Integer> curr, int[] nums, int index) {
                
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
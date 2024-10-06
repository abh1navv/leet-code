class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        findSubsets(ans, new ArrayList<>(), nums, 0);
        
        return new ArrayList<>(ans);
    }
    
    void findSubsets(Set<List<Integer>> ans, List<Integer> curr, int[] nums, int index) {
        ans.add(new ArrayList<>(curr));

        for(int i=index; i<nums.length; i++) {
            if(i>index && nums[i] == nums[i-1]) continue;

            curr.add(nums[i]);
            findSubsets(ans, curr, nums, i+1);
            curr.remove(curr.size()-1);
        }
    }
}
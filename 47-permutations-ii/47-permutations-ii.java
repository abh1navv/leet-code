class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        
        boolean[] seenIndexes = new boolean[nums.length];
        getPermutations(new ArrayList<>(), ans, nums, seenIndexes);

        return new ArrayList(ans);
    }
    
    public void getPermutations(List<Integer> current, Set<List<Integer>> ans, int[] nums, boolean[] seenIndexes) {
        if(current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
        }       
        
        for(int i=0; i<nums.length; i++) {
            if(!seenIndexes[i]) {
                seenIndexes[i] = true;
                current.add(nums[i]);
                getPermutations(current, ans, nums, seenIndexes);
                current.remove(current.size()-1);
                seenIndexes[i] = false;
            }
        }
    }
}
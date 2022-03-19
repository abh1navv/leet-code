class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        
        Set<Integer> seenIndexes = new HashSet<>();
        getPermutations(new ArrayList<>(), ans, nums, seenIndexes);

        List<List<Integer>> res = new ArrayList<>();

        for(List<Integer> list: ans) {
            res.add(list);
        }
        
        return res;
    }
    
    public void getPermutations(List<Integer> current, Set<List<Integer>> ans, int[] nums, Set<Integer> seenIndexes) {
        if(current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
        }       
        
        for(int i=0; i<nums.length; i++) {
            if(seenIndexes.add(i)) {
                current.add(nums[i]);
                getPermutations(current, ans, nums, seenIndexes);
                current.remove(current.size()-1);
                seenIndexes.remove(i);
            }
        }
    }
}
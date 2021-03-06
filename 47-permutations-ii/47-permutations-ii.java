class Solution {
    HashSet<List<Integer>> ans = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] seenIndexes = new boolean[nums.length];
        getPermutations(new ArrayList<>(), nums, seenIndexes);

        return new ArrayList(ans);
    }
    
    public void getPermutations(List<Integer> current, int[] nums, boolean[] seenIndexes) {
        if(current.size() == nums.length) {
            ans.add(new ArrayList(current));
            return;
        }       
        
        for(int i=0; i<nums.length; i++) {
            if(seenIndexes[i] 
               || (i>0 
               && nums[i]==nums[i-1] 
               && !seenIndexes[i-1])) continue;
            
            seenIndexes[i] = true;
            current.add(nums[i]);
            getPermutations(current, nums, seenIndexes);
            current.remove(current.size()-1);
            seenIndexes[i] = false;
            
        }
    }
}
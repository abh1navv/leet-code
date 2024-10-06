class Solution {
    
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        getSubsets(nums, ans, new ArrayList<>(), 0, target);
        return new ArrayList<>(ans);
    }
    
    
    void getSubsets(int[] nums, List<List<Integer>> ans, List<Integer> list, int lastIndex, int target) {
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        } else if(target < 0) {
            return;
        }
                
        
        for(int i=lastIndex;i<nums.length;i++) {
           if(i>lastIndex && nums[i]==nums[i-1]) continue;
            list.add(nums[i]);            
            getSubsets(nums, ans, list,i+1, target-nums[i]);
            list.remove(list.size()-1); 
            
        }
    }
    


}
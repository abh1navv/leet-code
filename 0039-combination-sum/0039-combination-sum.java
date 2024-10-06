class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        getSubsets(nums, ans, new ArrayList<Integer>(), 0, target);
        return ans;
    }
    
    
    void getSubsets(int[] nums, List<List<Integer>> ans, List<Integer> list, int lastIndex, int target) {
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        } else if(target < 0) {
            return;
        }
                
        
        for(int i=lastIndex;i<nums.length;i++) {
            list.add(nums[i]);            
            getSubsets(nums, ans, list,i, target-nums[i]);
            list.remove(list.size()-1); 
        }
    }
    
    
}

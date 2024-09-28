class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        
        //Set<List<Integer>> ans = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0; i<nums.length-2; i++) {
            while(i > 0 && i<nums.length-2 && nums[i] == nums[i-1]) i++;

            int j=i+1;
            int k= nums.length-1;
            
            
            while(j<k) {
                if(j>i+1 && j<k && nums[j] == nums[j-1]) {
                    j++;
                    continue;
                }
                
                if(nums[j] + nums[k] == -nums[i]) {
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if(nums[j] + nums[k] > -nums[i]) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        
        //return new ArrayList<>(ans);
        return ans;
    }
    
}
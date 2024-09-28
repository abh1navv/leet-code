class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0; i<nums.length-2; i++) {
            while(i > 0 && i<nums.length-2 && nums[i] == nums[i-1]) i++;

            int j=i+1;
            int k= nums.length-1;
            
            
            while(j<k) {
                
                if(nums[j] + nums[k] == -1*nums[i]) {
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    while(j< k && nums[j] == nums[j+1]) j++;
                    j++;
                    k--;
                } else if(nums[j] + nums[k] > -1*nums[i]) {
                    k--;
                } else {
                    while(j< k && nums[j] == nums[j+1]) j++;
                    j++;
                }
            }
        }
        
        return ans;
    }
    
}
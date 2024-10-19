class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findWays('+', 0, 0, target, nums) + findWays('-', 0, 0, target, nums);
    }
    
    int findWays(char sign, int index, int sum, int target, int[] nums) {
        
        
        int count = 0;
        
        if(sign == '+') sum+=nums[index];
        else sum-=nums[index];
        
        //System.out.println(sum);
        
        if(index == nums.length-1 && sum == target) return 1;
        else if(index== nums.length-1) return 0;
        
        count =  findWays('+', index+1, sum, target, nums) + findWays('-', index+1, sum, target, nums);
        
        
        return count;
    }
}
class Solution {
    public int waysToMakeFair(int[] nums) {
        int c = 0;
        int[] l =new int[2];
        int[] r =new int[2];
        
        for(int i=0;i<nums.length;i++) {
            r[i%2] += nums[i];
        }
        
        for(int i=0;i<nums.length;i++) {
            r[i%2]-=nums[i];
            if(r[0] + l[1] == r[1] + l[0]) c++;
            l[i%2]+=nums[i];
        }
        return c;
    }
    
}
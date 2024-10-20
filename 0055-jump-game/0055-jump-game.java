class Solution {
    public boolean canJump(int[] nums) {
        boolean[] canJump = new boolean[nums.length];
        canJump[nums.length-1] = true;
        for(int i=nums.length-2; i>=0; i--) {
            for(int j=i; j<=Math.min(i+nums[i], nums.length-1) ; j++) {
                if(canJump[j]) canJump[i] = true;
            }
        }
        
        return canJump[0];
    }
}
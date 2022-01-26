class Solution {
    public int trap(int[] height) {
        int maxLeft = 0, maxRight = 0;
        int left=0, right = height.length-1;
        int total = 0;
        
        while(left < right){
            if(height[left] <= height[right]) {
                if(height[left] >= maxLeft) 
                    maxLeft = height[left++];
                else 
                    total += maxLeft-height[left++];
            } else {
                if(height[right]>=maxRight) 
                    maxRight = height[right--];
                else 
                    total += maxRight-height[right--];
                                   
            }
        }
                
        return total;
    }
}
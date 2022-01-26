class Solution {
    public int trap(int[] height) {
        int maxLeft = height[0], maxRight = height[height.length-1];
        int left=0, right = height.length-1;
        int total = 0;
        
        while(left < right){
            if(height[left] < height[right]) {
                maxLeft = Math.max(height[left], maxLeft);
                total += maxLeft-height[left++];
            } else {
                maxRight = Math.max(height[right], maxRight);
                total += maxRight-height[right--];
            }
        }
                
        return total;
    }
}
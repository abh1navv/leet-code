class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        
        int water = (j-i) * Math.min(height[j], height[i]);
        
        while(i<j) {
            if(height[j] < height[i]){
               j--;
            } else {
               i++;
            } 
            water = Math.max(water, (j-i) * Math.min(height[j], height[i]));
        }
        
        
        return water;
    }
}
class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int first = 0;
        int last = len-1;
        
        int water = (last-first) * Math.min(height[last], height[first]);
        
        while(first<last) {
            water = Math.max(water, (last-first) * Math.min(height[last], height[first]));
            if(height[last] < height[first]) last--;
            else first++;
        }
        
        
        return water;
    }
}
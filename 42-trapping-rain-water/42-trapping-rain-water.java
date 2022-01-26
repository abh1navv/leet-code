class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxLeft = height[0], maxRight = height[n-1];
        int total = 0;
        
        int[] arr = new int[n];
        for(int i=1;  i<n-1;i++) {
            maxLeft= Math.max(maxLeft, height[i]);
            arr[i] = maxLeft;
        }
        for(int i=n-2;i>0;i--) {
            maxRight= Math.max(maxRight, height[i]);
            int max = Math.min(arr[i], maxRight);
            if(height[i] < max)
                total += max-height[i];
        }
                
        return total;
    }
}
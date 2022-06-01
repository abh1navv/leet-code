class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int maxSq = 0;
        int count = 0;
        
        for(int[] rectangle: rectangles) {
            int curr = Math.min(rectangle[0], rectangle[1]);
            if(curr > maxSq) {
                maxSq = curr;
                count = 1;
            } else if (curr == maxSq) {
                count++;
            }
        }
        
        return count;
    }
}
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i=0; i< flowerbed.length; i++) {
            if(flowerbed[i] == 1) continue;
            if(i+1 >= flowerbed.length && (i==0 || flowerbed[i-1] == 0)) {
                count++;
            } else if(i == 0 && i+1 < flowerbed.length && flowerbed[i+1] == 0) {
                count++;
                flowerbed[i] = 1;
            } else if(i+1 < flowerbed.length && flowerbed[i+1] == 0 && flowerbed[i-1] == 0) {
                count++;
                flowerbed[i] = 1;
            }
        } 
        
        return count >= n;
    }
}
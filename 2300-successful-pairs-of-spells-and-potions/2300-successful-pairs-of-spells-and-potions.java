class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int l=0, r=potions.length, mid;
        for(int i=0; i<spells.length; i++) {
            l=0;
            r=potions.length;
            
            long factor = (success + spells[i] - 1) / spells[i];
            while(l<r) {
                mid = l+(r-l)/2;
                if(potions[mid] >= factor) {
                    r = mid;
                } else {
                    l = mid+1;
                }
            }
            spells[i] = potions.length-l;
        }
        return spells;
    }
}
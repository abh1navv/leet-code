class Solution {
    public int singleNumber(int[] nums) {
        
        int check = 0;
        
        for(int n: nums) {
            check^=n;
        }
        
        return check;
    }
}
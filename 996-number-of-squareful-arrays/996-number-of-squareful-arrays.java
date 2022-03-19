class Solution {
    
    int count = 0;

    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        boolean[] seenIndexes = new boolean[nums.length];
        countPermutations(new ArrayList<>(), nums, seenIndexes);

        return count;
    }
    
    public void countPermutations(List<Integer> current, int[] nums, boolean[] seenIndexes) {
        if(current.size() == nums.length) {
            count++;
            return;
        }       
        
        for(int i=0; i<nums.length; i++) {
            if(seenIndexes[i] 
               || (i>0 
               && nums[i]==nums[i-1] 
               && !seenIndexes[i-1])) continue;
            
            if(current.isEmpty() 
               || isPerfectSquare(nums[i] + current.get(current.size()-1))) {
                seenIndexes[i] = true;
                current.add(nums[i]);
                countPermutations(current, nums, seenIndexes);
                current.remove(current.size()-1);
                seenIndexes[i] = false;
            }
        }
    }
    
    boolean isPerfectSquare(int n) {
        int x = (int)Math.sqrt(n);
        return n == x*x;
    }
    
}
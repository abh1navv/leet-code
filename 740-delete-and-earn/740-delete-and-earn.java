class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums== null) return 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        int max = 0;
        for(int n: nums) {
            countMap.put(n, countMap.getOrDefault(n,0) + n);
            max = Math.max(max, n);
        }
                
        int take=0, skip=0;
        int takePrev = 0;
        for(int i=1; i<=max; i++) {
            take = skip + countMap.getOrDefault(i, 0);
            skip = Math.max(skip, takePrev);
            takePrev = take;
        }
        
        return Math.max(take, skip);
    }
}
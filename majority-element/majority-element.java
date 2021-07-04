class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> hmap = new HashMap<>();
        int max=0,maxCount = 0;
        for(int n: nums) {
            int currCount = hmap.getOrDefault(n,0)+1;
            hmap.put(n, currCount);
            if(currCount>maxCount) {
                maxCount = currCount;
                max = n;
            }
        }
        return max;
    }
}
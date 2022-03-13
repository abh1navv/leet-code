class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;

        //System.out.println(map);
        
        int sum = 0;
        for(int i=0; i<len; i++) {
            sum = sum + nums[i];
            
            if(map.containsKey(sum-k)) {
                count+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0) +1);
        }
        
        return count;
    }
}
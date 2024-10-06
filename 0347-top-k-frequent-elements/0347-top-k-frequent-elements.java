class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> numToCount = new HashMap<>();
        
        
        for(int n: nums) {
            int prev = numToCount.getOrDefault(n,0);
            numToCount.put(n, ++prev);
        }
        
        final int[] ans = new int[k];
        int index=0;
        //System.out.println(numToCount);
        
        List<Integer> ansList = numToCount.entrySet().stream().sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue())).map(entry -> entry.getKey()).toList();
        ansList = ansList.subList(0,k);
        
        //System.out.println(ansList);
        
        for(int key: ansList) {
            ans[index++]=  key;
        }
        
        return ans;
    }
}
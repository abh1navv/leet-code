class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        int count;
        for(int n:nums1) {
            count = map.getOrDefault(n, 0);
            map.put(n, count+1);
        }
        
        for(int n:nums2) {
            count = map.getOrDefault(n, 0);
            if(count>0) {
                ans.add(n);
            } 
            map.put(n, count-1);
        }
        
        int[] arr = new int[ans.size()];
        
        for(int i=0; i<arr.length; i++) {
            arr[i] = ans.get(i);
        }
        
        return arr;
    }
}
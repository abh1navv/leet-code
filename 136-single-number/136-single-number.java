class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int i:nums) {
            if(set.contains(i)) count-=i;
            else {
                count+=i;
                set.add(i);
            }
        }
        
        return count;
    }
}
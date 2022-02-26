class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        powerSet.add(new ArrayList<Integer>());
        //for(int i=0; i<= nums.length;i++) {
            getSubsets(nums, powerSet, new ArrayList<Integer>(), 0);
        //}
        return powerSet;
    }
    
    void getSubsets(int[] nums, List<List<Integer>> powerSet, List<Integer> list, int lastIndex) {
        
        for(int i=lastIndex;i<nums.length;i++) {
            if(!list.contains(nums[i])) {
                list.add(nums[i]);
                powerSet.add(new ArrayList<>(list));
                getSubsets(nums, powerSet, list,i);
                list.remove(list.size()-1);
            }
        }
    }
    
    
}
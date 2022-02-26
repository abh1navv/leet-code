

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> powerSet = new ArrayList<>();
        powerSet.add(new ArrayList<Integer>());
        getSubsets(nums, powerSet, new ArrayList<Integer>(), 0);

        return powerSet;
    }
    
    void getSubsets(int[] nums, List<List<Integer>> powerSet, List<Integer> list, int lastIndex) {
        for(int i=lastIndex;i<nums.length;i++) {
            if(i>lastIndex && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            powerSet.add(new ArrayList<>(list));
            getSubsets(nums, powerSet, list,i+1);
            list.remove(list.size()-1);
        }
    }
    
    
}
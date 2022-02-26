

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> powerSet = new ArrayList<>();
        getSubsets(nums, powerSet, new ArrayList<Integer>(), 0);

        return powerSet;
    }
    
    void getSubsets(int[] nums, List<List<Integer>> powerSet, List<Integer> list, int lastIndex) {
        powerSet.add(new ArrayList<>(list));

        for(int i=lastIndex;i<nums.length;i++) {
            if(i>lastIndex && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            getSubsets(nums, powerSet, list,i+1);
            list.remove(list.size()-1);
        }
    }
    
    
}


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> powerSet = new HashSet<>();
        powerSet.add(new ArrayList<Integer>());
        getSubsets(nums, powerSet, new ArrayList<Integer>(), 0, nums.length);
        List<List<Integer>> powerList=new ArrayList<>();
        powerList.addAll(powerSet);
        // for(List<Integer> x: powerSet) {
        //     powerList.add(x);
        // }
        return powerList;
    }
    
    void getSubsets(int[] nums, Set<List<Integer>> powerSet, List<Integer> list, int lastIndex, int len) {
        for(int i=lastIndex;i<nums.length;i++) {
            list.add(nums[i]);
            powerSet.add(new ArrayList<>(list));
            getSubsets(nums, powerSet, list,i+1,len);
            list.remove(list.size()-1);
        }
    }
    
    
}
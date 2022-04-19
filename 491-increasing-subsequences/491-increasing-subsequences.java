class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(nums, 0, curr, res);
        return res;
    }
    
    void backtrack(int[] nums, int start, List<Integer> curr, List<List<Integer>> res) {
        if(curr.size() > 1) {
            res.add(new ArrayList<>(curr));
        }
        Set<Integer> checked = new HashSet<>();

        for(int i=start; i<nums.length; i++) {
            if(!checked.add(nums[i])) continue;
            if(curr.isEmpty() || nums[i]>=curr.get(curr.size()-1)) {
                curr.add(nums[i]);
                backtrack(nums, i+1, curr, res);
                curr.remove(curr.size()-1);
            }
        }
    }
}
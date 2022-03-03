class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        //Arrays.sort(candidates);
        getCombinations(candidates, target, ans, new LinkedList<>(), 0);
        return ans;
    }
    
    public void getCombinations(int[] candidates, int target, List<List<Integer>> ans, 
                           List<Integer> current, int index) {
        if(target == 0) {
            ans.add(new ArrayList<Integer>(current));
        } else if(target < 0) {
            return;
        } else {
            for(int i=index; i< candidates.length; i++) {
                current.add(candidates[i]);
                getCombinations(candidates, target-candidates[i], ans, current, i);
                current.remove(current.size()-1);
            }
        }

    }
}
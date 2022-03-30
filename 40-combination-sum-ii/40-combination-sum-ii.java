class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        
        getCombinations(candidates, 0, new ArrayList<>(), ans, target);
        
        return ans;
    }
    
    public void getCombinations(int[] candidates, int start, List<Integer> curr, List<List<Integer>> ans, int target) {
        if(target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        } 
        
        for(int i=start; i<candidates.length; i++) {
            if(i>0 && i!=start && candidates[i]==candidates[i-1]) continue;
            if(target-candidates[i] >=0) {
                curr.add(candidates[i]);
                getCombinations(candidates, i+1, curr, ans, target-candidates[i]);
                curr.remove(curr.size()-1);
            }
        }
    }
}
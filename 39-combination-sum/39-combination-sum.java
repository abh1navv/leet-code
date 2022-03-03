class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> current = new LinkedList<>();
        for(int i=0; i< candidates.length; i++) {
            getCombinations(candidates, target, ans, current, i);
        }
        List<List<Integer>> list = new ArrayList<>();
        for(List<Integer> ans1: ans) {
            list.add(ans1);
        }
        return list;
    }
    
    public void getCombinations(int[] candidates, int target, Set<List<Integer>> ans, 
                           List<Integer> current, int index) {
        if(target == 0) {
            ans.add(new ArrayList<Integer>(current));
        } else if(target < 0) {
            return;
        }
        current.add(candidates[index]);
        for(int i=index; i< candidates.length; i++) {
            getCombinations(candidates, target-candidates[index], ans, current, i);
        }
        current.remove(current.size()-1);

    }
}
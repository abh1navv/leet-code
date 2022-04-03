class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        getCombinations(1,new ArrayList<>(), ans, k, n);
        
        return ans;
    }
    
    void getCombinations(int start, List<Integer> curr, List<List<Integer>> ans, int k, int n) {

        if(curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=start;i<=n;i++) {
            curr.add(i);
            getCombinations(i+1, curr, ans, k, n);
            curr.remove(curr.size()-1);
        }
        
    }
}
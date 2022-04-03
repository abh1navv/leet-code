class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        getCombinations(1,new ArrayList<>(), ans, k, n);
        
        return ans;
    }
    
    void getCombinations(int start, List<Integer> curr, List<List<Integer>> ans, int k, int n) {

        if(curr.size() == k && n==0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=start;i<=9;i++) {
            curr.add(i);
            getCombinations(i+1, curr, ans, k, n-i);
            curr.remove(curr.size()-1);
        }
        
    }
}
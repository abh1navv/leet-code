class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tempList  = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        findCombinations(1, k, n);
        return ans;
    }
    
    void findCombinations(int curr, int k, int n) {
        if(n == 0 && tempList.size() == k) {
            ans.add(new ArrayList<>(tempList));
            return;
        }
        
        if(tempList.size() == k) return;
        
        for(int i=curr; i<=9; i++) {
            tempList.add(i);
            findCombinations(i+1, k, n-i);
            tempList.remove(tempList.size()-1);
        }
    }
    
    
}
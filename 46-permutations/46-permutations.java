class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();        
        getPerms(answer, new ArrayList<>(), nums);

        return answer;
    }
    
    public void getPerms(List<List<Integer>> answer, List<Integer> currentList, int nums[]) {
        if(currentList.size() == nums.length) {
            answer.add(new ArrayList<>(currentList)); 
            return;
        }
        for(int i: nums) {    
            if(!currentList.contains(i)) {
                currentList.add(i);
                getPerms(answer, currentList, nums);
                currentList.remove(currentList.size()-1);
            }
        }
    }
}
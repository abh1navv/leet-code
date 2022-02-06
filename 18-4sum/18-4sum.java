class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> resList = new ArrayList<>();
        
        
        for(int i=0; i<len-3; i++) {
            long fourNum = ((long)nums[i])*4;
            if(target < fourNum){
                break;
            }
            for(int j=i+1; j<len-2; j++) {
                int x = nums[i] + nums[j];
                
                int y = target - x;
                
                if(target<x*2) break;
                
                int a=j+1, b=len-1;
                while(a < b) {
                    if(y < nums[a] + nums[b]) b--;
                    else if (y> nums[a] + nums[b]) a++;
                    else {
                        Integer[] arr = {nums[i], nums[j], nums[a], nums[b]};
                        resList.add(Arrays.asList(arr));
                        while(a<b && nums[a+1] == nums[a]) a++;
                        while(b>a && nums[b-1] == nums[b]) b--;
                        a++;
                        b--;
                    }
                }
            }
        }
        Set<List<Integer>> set = new HashSet<>(resList);
        resList.clear();
        for (List<Integer> x : set)
            resList.add(x);
        return resList;
    }
}
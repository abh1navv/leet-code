class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i=0;i<len;i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            int rem = -nums[i];
            int end = len - 1;
            int start = i+1;
            while(start<end) {
                if(start>i+1 && nums[start] == nums[start-1]) {
                    start++;
                    continue;
                }
                int currsum = nums[start] + nums[end];
                if(currsum == rem) {
                    result.add(List.of(nums[i],nums[start],nums[end]));
                    start++;
                } else if (currsum < rem) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }
    
    
}
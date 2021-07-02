class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        int currsum, start,end,rem;
        for(int i=0;i<len;i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            rem = -nums[i];
            end = len - 1;
            start = i+1;
            while(start<end) {
                if(start>i+1 && nums[start] == nums[start-1]) {
                    start++;
                    continue;
                }
                currsum = nums[start] + nums[end];
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
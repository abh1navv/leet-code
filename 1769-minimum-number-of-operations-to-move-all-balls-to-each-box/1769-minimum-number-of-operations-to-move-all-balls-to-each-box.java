class Solution {
    public int[] minOperations(String boxes) {
        int[] nums = boxes.chars().map(c -> c-48).toArray();
        int[] prefix = new int[nums.length];
        prefix[0] = 0;
        int count = nums[0];
        for(int i=1; i<prefix.length; i++) {
            prefix[i] = count + prefix[i-1];
            if(nums[i] == 1) count++;
        }
        //System.out.println(Arrays.toString(prefix));
        count = nums[nums.length-1];
        nums[nums.length-1] = 0;

        for(int i=nums.length-2; i>=0; i--) {
            //nums[i] = count + prefix[i];
            //prefix[i] += nums[i];
            nums[i] = nums[i+1] + count;
            prefix[i] += nums[i];
            if(boxes.charAt(i) == '1') count++;
        }
        //System.out.println(Arrays.toString(nums));

        
        return prefix;
    }
}
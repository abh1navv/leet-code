class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int p0=0,p2=len-1;
        for(int i=0;i<=p2 && p0<=p2;i++) {
            int temp = 0;
            if(i>p0 && nums[i] == 0) {
                temp = nums[p0];
                nums[p0++] = nums[i];
                nums[i] = temp;
                i--;
            } else if(i<p2&&nums[i] == 2) {
                temp = nums[p2];
                nums[p2--] = nums[i];
                nums[i] = temp;
                i--;
            }
            System.out.println(Arrays.toString(nums));
        }
    }
}
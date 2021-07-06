class Solution {
    public int[] searchRange(int[] nums, int target) {
        int end = nums.length-1;
        int pos = binarySearch(nums, target, 0,0,end);
                System.out.println(pos);

        if(pos == -1){
           int[] res = {-1,-1}; 
            return res;
        } 
        int first = binarySearch(nums,target,-1,0,pos);
        System.out.println(first);
        if(first == -1) first = pos;
        int last = binarySearch(nums,target,1,pos+1,end);
        System.out.println(last);

        if(last == -1) last = pos;
        int[] res = {first,last};
        return res;
    }
    
    public int binarySearch(int[] nums, int target, int find, int start, int end) {
        while(start<=end) {
            int m = (start+end)/2;
                    System.out.println(start+":"+end+":"+m);

            if(nums[m] == target) {
                if(find == 0) return m;
                else if(find == -1) end = m-1;
                else if(find == 1) start = m+1;
            } else if(nums[m] > target) {
                if(find == 1 && nums[m-1] == target) return m-1;
                else end = m-1;
            } else {
                if(find == -1 && nums[m+1]==target) return m+1;
                else start = m+1;
            }
        }
        return find==1?end:(find==-1)?start:-1;
    }
}
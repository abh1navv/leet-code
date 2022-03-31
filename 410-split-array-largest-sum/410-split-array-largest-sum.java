class Solution {
    public int splitArray(int[] nums, int m) {
        int sum=0, max=0;
        for(int n:nums) {
            sum+=n;
            max = Math.max(max, n);
        }
        if(m==1) return sum;
        int l=max, r=sum;

        while(l<=r) {
            int mid = (l+r)/2;
            if(valid(nums, m, mid)) {
                r=mid-1;
            } else {
                l=mid+1;
            }
        }
        
        return l;
    }
    
    boolean valid(int[] nums, int m, int max) {
        int count=1, total=0;
        for(int n:nums) {
            total+=n;
            if(total>max) {
                total=n;
                count++;
                if(count>m){
                    return false;
                }
            }
        }
        return true;
    }
}
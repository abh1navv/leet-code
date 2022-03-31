class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum=0, max=0;
        for(int w:weights) {
            sum+=w;
            max = Math.max(max, w);
        }
        if(days==1) return sum;
        int least=max, most=sum;
        
        while(least<=most) {
            int mid = (least+most)/2;
            if(valid(mid, days, weights)) {
                most = mid-1;
            } else {
                least = mid+1;
            }
        }
        
        return least;
    }
    
    boolean valid(int capacity, int days, int[] weights) {
        int count=1, total=0;
        for(int w:weights) {
            total+=w;
            if(total > capacity) {
                count++;
                total=w;
                if(count>days) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
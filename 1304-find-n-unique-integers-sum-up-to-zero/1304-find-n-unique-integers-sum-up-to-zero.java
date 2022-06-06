class Solution {
    public int[] sumZero(int n) {
        int sum=0;
        int[] arr=new int[n];
        
        int half = n/2+1;
        
        for(int i=1; i<half;i++) {
            arr[i-1]=i;
            sum+=i;
            if(i+half<=n) {
                arr[i+half-1]=-i;
                sum-=i;
            }
        }
        if(n%2==0) {
            arr[n/2] = -sum;
        }
        return arr;
    }
}
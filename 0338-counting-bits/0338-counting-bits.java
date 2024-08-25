class Solution {
    public int[] countBits(int n) {
        int arr[]=new int[n+1];
        for(int i=0; i<=n; i++) {
            int count = 0;
            int j=i;
            while(j>0) {
                if(arr[j] !=0) {
                    count+=arr[j];
                    break;
                }
                count+= j%2;
                j/=2;
            }
            arr[i] = count;
        }
        
        return arr;
    }
    
}
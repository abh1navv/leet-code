class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int res=0, mod=1000000007;
        for(int i=0; i<arr.length-2;i++) {
            int diff = target-arr[i], count=0;
            int j=i+1,k=arr.length-1;
            while(j<=k) {
                if(arr[j]+arr[k] == diff) {
                    if(arr[j]!=arr[k]) {
                        int temp = k;
                        int tempJ=1;
                        while(j<k && arr[j]==arr[j+1]) {
                            j++;
                            tempJ++;
                        }
                        int tempK=1;
                        while(k>j && arr[k]==arr[k-1]) {
                            k--;
                            tempK++;
                        }
                        count += (tempK*tempJ)%mod;
                        j++;
                        k--;
                    } else {
                        int n=k-j+1;
                        count += ((n*(n-1))/2)%mod;
                        break;
                    }
                } else if(arr[j]+arr[k] < diff){
                    j++;
                } else {
                    k--;
                }
            }
            res = (res+count)%mod;
        }
        
        return res;
    }
}
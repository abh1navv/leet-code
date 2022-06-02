class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int len = arr.length;
        Arrays.sort(arr);
        double median = len%2==1 ? arr[len/2]: arr[len/2-1];
        
        int i=0, j=len-1, index=0;
        int[] res=new int[k];
        while(index<k) {
            if(Math.abs(arr[i]-median) > Math.abs(arr[j]-median)) {
                res[index++] = arr[i++];
            } else {
                res[index++] = arr[j--];
            }
        }
        
        return res;
    }
}
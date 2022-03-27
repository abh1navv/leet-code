class Solution {
    public boolean validMountainArray(int[] arr) {
        boolean increasing = true;
        
        if(arr.length<2 || arr[1]<=arr[0]) return false;
        
        for(int i=1; i<arr.length;i++) {
            if(increasing) {
                increasing = arr[i] > arr[i-1];
            } else if(arr[i]>=arr[i-1]) {
                return false;
            }
        }
        return arr[arr.length-1] < arr[arr.length-2];
    }
}
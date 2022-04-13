class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Arrays.sort(arr);
        List<Integer> ans = new ArrayList<>();
        int i=k;
        while(i!=arr.length && arr[i]-x < x-arr[i-k]) {
            i++;
        }
        
        for(int j=i-k; j<i; j++) {
            ans.add(arr[j]);
        }
        
        return ans;
    }
}
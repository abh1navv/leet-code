class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Arrays.sort(arr);
        int i=k;
        while(i!=arr.length && arr[i]-x < x-arr[i-k]) {
            i++;
        }
        return IntStream.range(i-k,i).map(j->arr[j]).boxed().toList();
    }
}
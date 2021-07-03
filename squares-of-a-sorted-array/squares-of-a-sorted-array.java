class Solution {
    public int[] sortedSquares(int[] nums) {
         
        return Arrays.stream(nums).parallel().
            boxed().
            sorted((a,b) -> (a*a)-(b*b)).
            mapToInt(i -> i*i).
            toArray();
    }
}
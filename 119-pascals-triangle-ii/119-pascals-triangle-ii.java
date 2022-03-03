class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] current = new int[rowIndex+1];
        current[0] = 1;
        for(int i=1; i<rowIndex+1;i++){
            for(int j=i; j>=1;j--) {
                current[j] += current[j-1];
            }
        }
        
        return Arrays.stream(current).boxed().collect(Collectors.toList());
    }
}
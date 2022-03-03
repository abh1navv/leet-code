class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] current = new Integer[rowIndex+1];
        current[0] = 1;
        for(int i=1; i<rowIndex+1;i++){
            current[i] = 0;
            for(int j=i; j>=1;j--) {
                current[j] += current[j-1];
            }
        }
        
        return Arrays.asList(current);
    }
}
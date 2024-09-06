class Solution {
    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> rowMap = new HashMap<>();

        
    
        for(int i=0;i<grid.length;i++) {
            List<Integer> rowList = new ArrayList<>();
            for(int j=0; j<grid[0].length;j++) {
                rowList.add(grid[i][j]);
            }
            rowMap.put(rowList, rowMap.getOrDefault(rowList, 0) + 1);
        }
        
        int count=0;

        for(int i=0;i<grid[0].length;i++) {
             List<Integer> colList = new ArrayList<>();
            for(int j=0; j<grid.length;j++) {
                colList.add(grid[j][i]);
            }
            count += rowMap.getOrDefault(colList, 0);
        }
        

        return count;
    }
}
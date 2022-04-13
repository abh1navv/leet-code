class Solution {
    public List<Integer> spiralOrder(int[][] grid) {
        List<Integer> ans = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        int rowStart=0, colStart=0, rowEnd=n-1, colEnd=m-1;
        
        while(rowStart <= rowEnd && colStart<= colEnd) {
            //traverse right
            for(int i=colStart; i<=colEnd; i++) {
                ans.add(grid[rowStart][i]);
            }
            rowStart++;
            //traverse down
            for(int i=rowStart; i<=rowEnd; i++) {
                ans.add(grid[i][colEnd]);
            }
            colEnd--;
            //traverse left
            if(rowStart<=rowEnd) {
                for(int i=colEnd; i>=colStart; i--) {
                    ans.add(grid[rowEnd][i]);
                }
                rowEnd--;
            }
            //traverse up
            if(colStart<=colEnd) {
                for(int i=rowEnd; i>=rowStart; i--) {
                    ans.add(grid[i][colStart]);
                }
                colStart++;
            }
        }
        return ans;
    }
}
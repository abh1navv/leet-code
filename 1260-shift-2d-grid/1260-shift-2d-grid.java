class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length, cols=grid[0].length;

        int[][] ans = new int[rows][cols];
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length;j++) {
                int newJ = (j+k)%cols;
                int newI = i+(j+k)/cols;
                ans[newI%rows][newJ]= grid[i][j];
            }
        }
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0; i<rows;i++) {
            res.add(new ArrayList<Integer>());
            for(int j=0; j<cols; j++)
                res.get(i).add(ans[i][j]);
        }
        
        return res;

    }
}
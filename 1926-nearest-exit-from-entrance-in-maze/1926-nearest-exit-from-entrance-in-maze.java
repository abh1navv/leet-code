class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int minDepth = 0;
        
        List<Pair> queue=new ArrayList<>();
        queue.add(new Pair(entrance[0], entrance[1]));
        maze[entrance[0]][entrance[1]] = '+';
        
        int index = 0;
        int row, col;
        
        while(index < queue.size()) {
            int len = queue.size();
            minDepth++;
            while(index<len) {
                Pair pair = queue.get(index);
                row = pair.a;
                col = pair.b;
                if(row > 0 && maze[row-1][col] == '.') {
                    if(row-1 == 0 || col==0 || col==maze[0].length-1) {
                        return minDepth;
                    } else {
                        queue.add(new Pair(row-1, col));
                       maze[row-1][col] = '+';

                    }
                } 
                if(row < maze.length-1 && maze[row+1][col] == '.') {
                    if(row+1 == maze.length-1 || col==0 || col==maze[0].length-1) {
                        return minDepth;
                    } else {
                        queue.add(new Pair(row+1, col));
                                maze[row+1][col] = '+';

                    }
                } 
                if(col > 0 && maze[row][col-1] == '.') {
                    if(col-1 == 0 || row==0 || row==maze.length-1) {
                        return minDepth;
                    } else {
                        queue.add(new Pair(row, col-1));
                                maze[row][col-1] = '+';

                    }
                } 
                if(col < maze[0].length-1 && maze[row][col+1] == '.') {
                    if(col+1 ==  maze[0].length-1 || row==0 || row==maze.length-1) {
                        return minDepth;
                    } else {
                        queue.add(new Pair(row, col+1));
                        maze[row][col+1] = '+';

                    }
                }
                index++;
                //System.out.println(queue);
            }
        }
        
        return -1;
    }
    
    private static class Pair {
        int a;
        int b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        
        public String toString() {
            return a+":"+b;
        }
    }
        
}
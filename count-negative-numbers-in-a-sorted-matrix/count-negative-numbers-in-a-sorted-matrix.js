/**
 * @param {number[][]} grid
 * @return {number}
 */
const countNegatives = function(grid) {
    const n = grid.length
    const m = grid[0].length
    let i=n-1, j=0, count = 0
    while(i>=0 && j<m) {
        if(grid[i][j] < 0) {
            count += m - j
            i--
        } else {
            j++
        }
    }
    return count   
}
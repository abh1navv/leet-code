/**
 * @param {number[][]} grid
 * @return {number}
 */
var gridGame = function(grid) {
    let ts=0, ls = 0;
    let res = Number.POSITIVE_INFINITY;
    const len = grid[0].length
    for(let j=0; j<len; j++) {
        ts += grid[0][j]
    }
    for(let j=0; j<len; j++) {
        ts -= grid[0][j]
        res = Math.min(res, Math.max(ls, ts))
        ls += grid[1][j]
    }
    return res
};
/**
 * @param {number} numRows
 * @return {number[][]}
 */
const generate = function(numRows) {
    const res = [[1]]
    for(let i=0; i<numRows-1; i++) {
        res[i+1] = []
        for(let j=0; j<i+2; j++) {
            res[i+1].push((res[i][j-1] ?? 0) + (res[i][j] ?? 0))
        }
    }     
    return res
}
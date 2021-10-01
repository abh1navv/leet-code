/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function(numRows) {
    const res = [[1]]
    for(let i=0; i<numRows-1; i++) {
        res[i+1] = []
        for(let j=0; j<i+2; j++) {
            const left = j>0 ? res[i][j-1] : 0 
            const right = j<res[i].length ? res[i][j] : 0 
            res[i+1].push(left+right)
        }
    }  
    
    return res
};
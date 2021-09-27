/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {boolean[]} hasApple
 * @return {number}
 */
const minTime = function(n, edges, hasApple) {
    const incomingEdge = []
    const set = new Set()

    for(let i=0; i<n-1; i++) {
        incomingEdge[edges[i][1]] = edges[i][0]
        if(hasApple[i+1]) {
           set.add(i+1) 
        }
            
    }
    let steps = 0
    
    for(let item of set) {
        if(item !== 0) {
            set.add(incomingEdge[item])
            steps+=2
        }
    }
    
    return steps
}
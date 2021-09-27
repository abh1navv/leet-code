/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {boolean[]} hasApple
 * @return {number}
 */
var minTime = function(n, edges, hasApple) {
    let incomingEdge = []
    for(let i=0; i<n-1; i++) {
        incomingEdge[edges[i][1]] = edges[i][0]
    }
    let toVisit = []
    let set = new Set()
    let steps = 0
    for(let i=1; i< n; i++) {
        if(hasApple[i]) 
            set.add(i)
    }
    
    //while(set.size >= 3) {
      //  console.log(set)
        for(let item of set) {
            console.log(item)
            if(item == 0) continue
            else {
                set.add(incomingEdge[item])
                //set.delete(item)
                steps+=2
            }
        }
    //}
    
    return steps
};
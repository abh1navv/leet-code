
/**
 * @param {number[][]} points
 * @param {number[][]} queries
 * @return {number[]}
 */
const countPoints = function(points, queries) {
    const result = []

    queries.forEach(query => {
        const xCord = query[0]
        const yCord = query[1]
        const radius = Math.pow(query[2], 2)
        let currRes = 0
        points.forEach(point => {
            const xPoint = point[0]
            const yPoint = point[1]
            
            const distance = Math.pow(xPoint - xCord, 2) + Math.pow(yPoint - yCord, 2)
            if(distance <= radius) {
                currRes++
            }
        })
        
        result.push(currRes)
    })
    
    return result
}


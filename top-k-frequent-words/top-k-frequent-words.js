/**
 * @param {string[]} words
 * @param {number} k
 * @return {string[]}
 */
var topKFrequent = function(words, k) {
    const res = []
    const wordMap = {}
    for(let item of words) {
        if(wordMap[item] !== undefined) {
            wordMap[item] ++
        } else {
            wordMap[item] = 1
        }
    }
    
    const freqArr = []
    Object.entries(wordMap).forEach((entry) => {
        if(freqArr[entry[1]] === undefined) {
            freqArr[entry[1]] = [entry[0]]
        } else {
            freqArr[entry[1]].push(entry[0])
        }
    })
    
    let i = 0, j=freqArr.length-1
    while(i!=k) {
        let values = freqArr[j--]
        if(values === undefined) continue
        else values.sort()
        
        if(values.length < k-i) {
            i+=values.length
            res.push(...values)
        } else {
            res.push(...values.slice(0,k-i))
            i=k
        }
    }
    return res
    
    
};
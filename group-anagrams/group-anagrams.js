/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    const sortedStrs = {}
    const answer = []
    for(let item in strs) {
        const sortedItem = sortedString(strs[item])
        if(sortedStrs.hasOwnProperty(sortedItem)) {
            sortedStrs[sortedItem].push(item)
        } else {
            sortedStrs[sortedItem] = [item]
        }
    }
    let index = 0
    for(let prop in sortedStrs) {
        const values = sortedStrs[prop]
        const len = values.length
        answer.push([strs[values[0]]])
        for(let i=1; i<len; i++) {
            const value = values[i]
            answer[index].push(strs[value])
        }
        index++
    }
    //console.log(answer)
    return answer
}

const sortedString = function(str) {
    return str.split('').sort().join('')
}
/**
 * @param {string[]} strs
 * @return {string[][]}
 */
const groupAnagrams = function(strs) {
    const sortedStrs = {}
    const answer = []
    let index = 0

    for(let item in strs) {
        const sortedItem = sortedString(strs[item])
        if(sortedStrs.hasOwnProperty(sortedItem)) {
            answer[sortedStrs[sortedItem]].push(strs[item])
        } else {
            sortedStrs[sortedItem] = index++
            answer.push([strs[item]])
        }
    }
    
    return answer
}

const sortedString = function(str) {
    return str.split('').sort().join('')
}
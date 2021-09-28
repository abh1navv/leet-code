const charCount = new Array(26)
/**
 * @param {string[]} strs
 * @return {string[][]}
 */
const groupAnagrams = function(strs) {
    const map = {}
    const answer = []
    let index = 0
     
    for(const item of strs) {     
        const sortedItem = getSortedItem(item)
        const mapValue = map[sortedItem]
        if(undefined !== mapValue) {
            answer[mapValue].push(item)
        } else {
            map[sortedItem] = index++
            answer.push([item])
        }
    }
    return answer
}

const getSortedItem = function(item) {
    charCount.fill(0)
    item.split('').forEach(ch => {
        charCount[ch.charCodeAt() - 97]++
    })
    return charCount.join('-')
}


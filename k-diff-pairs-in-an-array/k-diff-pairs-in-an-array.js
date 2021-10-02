/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
const findPairs = function(nums, k) {  
    let count = 0
    if(k === 0) {
        return zeroCase(nums)
    } else {
        const map = {}
        for(let i=0; i< nums.length; i++) {
            let negativeEntry = map[nums[i] - k]
            let positiveEntry = map[nums[i] + k]
            if(negativeEntry !== undefined && (map[nums[i]] === undefined)) {
                count++
            } 
            if(positiveEntry !== undefined && (map[nums[i]] === undefined)) {
                count++
            }
            map[nums[i]] = i
        }
    }
    return count
}
    
const zeroCase = function(nums) {
    const map = {}
    let count = 0
    for(let i=0; i< nums.length; i++) { 
        if(map[nums[i]] === undefined) {
            map[nums[i]] = 1
        } else if(map[nums[i]] === 1) {
            count++
            map[nums[i]] = 2
        }
    }
    return count
}
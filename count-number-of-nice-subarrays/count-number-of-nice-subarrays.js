/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
const numberOfSubarrays = function(nums, k) {
    let count = 0
    const curr = [-1]
    let first = 1
    for(let i= 0; i< nums.length; i++) {
        const item = nums[i]
        if(item % 2 === 1) {
            curr.push(i)
        } 
        if( curr.length > k+first ) { 
            first++
        }
        if( curr.length === k + first ) { 
            count = count + (curr.length > first ? curr[first] : i) - curr[first-1]
        }
    } 
    
    return count
}

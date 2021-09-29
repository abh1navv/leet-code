/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
const numberOfSubarrays = function(nums, k) {
    let count = 0
    const curr = [-1]
    let first = 0
    for(let i= 0; i< nums.length; i++) {
        const item = nums[i]
        if(item % 2 === 1) {
            curr.push(i)
        } 
        if(curr.length - first > k+1 ) { 
            first++
        }
        if(curr.length - first === k+1 ) { 
            count = count + (curr.length > first+1 ? curr[first+1] : i) - curr[first]
        }
    } 
    
    return count
}

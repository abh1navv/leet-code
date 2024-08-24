/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        boolean found = false;
        int low = 1;
        while(found != true) {
            int curr = low+(n-low)/2;

            if(guess(curr) == 0) return curr;
            else if(guess(curr) == -1) {
                n = curr-1;
            } else {
                low = curr+1;
            }
        }
        
        return -1;
    }
}
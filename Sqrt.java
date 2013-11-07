/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/

public class Solution {
    public int sqrt(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (x <= 1) {
            return x;
        }
        int start = 0;
        int end = x;
        int mid;
        while (end >= start) {
                mid = (start + end) / 2;
                int div = x / mid;
                if (div < mid) {
                    end = mid - 1;
                } else if (div == mid) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            
        }
        return (start + end) / 2;
    }
}
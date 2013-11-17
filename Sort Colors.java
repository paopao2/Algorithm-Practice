/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/

public class Solution {
    public void sortColors(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int i = -1;
        int j = A.length;
        
        for (int cur = 0; cur < j; cur++) {
            if (A[cur] == 0) {
                i++;
                int temp = A[cur];
                A[cur] = A[i];
                A[i] = temp;
                
            } else if (A[cur] == 2) {
                j--;
                int temp = A[cur];
                A[cur] = A[j];
                A[j] = temp;
                cur--;
            }
        }
    }
}
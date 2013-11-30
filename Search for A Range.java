/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

public class Solution {
    public int[] searchRange(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int[] result = new int[2];
        result[0] = findStartIndex(A, 0, A.length - 1, target);
        result[1] = findEndIndex(A, 0, A.length - 1, target);
        return result;
    }
    
    public int findStartIndex(int[] A, int start, int end, int target) {
        if (start > end || start < 0 || end > A.length - 1) return -1;
        if (A[end] < target) {
            if (end == A.length - 1 || A[end + 1] != target) return -1;
            else return end + 1;
        }
        
        int mid = (start + end) / 2;
        if (A[mid] < target) {
            return findStartIndex(A, mid + 1, end, target);
        } else {
            if (A[mid] == target && mid == start) return mid;
            return findStartIndex(A, start, mid - 1, target);
        }
    }
    
    public int findEndIndex(int[] A, int start, int end, int target) {
        if (start > end || start < 0 || end > A.length - 1) return -1;
        if (A[start] > target) {
            if (start == 0 || A[start - 1] != target) return -1;
            else return start - 1;
        }
        
        int mid = (start + end) / 2;
        if (A[mid] <= target) {
            if (A[mid] == target && mid == end) return mid;
            return findEndIndex(A, mid + 1, end, target);
        } else {
            return findEndIndex(A, start, mid - 1, target);
        }
    }
}
public class Solution {
    public int search(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return searchHelper(A, 0, A.length - 1, target);
    }
    
    public int searchHelper(int[] A, int start, int end, int target) {
        int mid = (start + end) / 2;
        if (A[mid] == target) {
            return mid;
        }
        if (start > end) {
            return -1;
        }
        
        //compare target with A[start],A[end], use <=, >=
        
        //left part is sorted
        if (A[mid] >= A[start]) {
            if (A[start] <= target && A[mid] > target) {
                return searchHelper(A, start, mid - 1, target);
            } else {
                return searchHelper(A, mid + 1, end, target);
            }
        }
        //right part is sorted
        if (A[mid] <= A[end]) {
            if (A[mid] < target && A[end] >= target) {
                return searchHelper(A, mid + 1, end, target);
            } else {
                return searchHelper(A, start, mid - 1, target);
            }
        } 
        return -1;
    }
}
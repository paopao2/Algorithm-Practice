/*
There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/

//it is frustrating to manipulate arrays in Java.

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return helper(A, 0, A.length, B, 0, B.length);
    }
    
    public double helper(int A[], int AStart, int AEnd, int B[], int BStart, int BEnd) {
        if (AEnd == 0) {
            return findMedianSingleArray(B, BStart, BEnd);
        } else if (BEnd == 0) {
            return findMedianSingleArray(A, AStart, AEnd);
        } else if (AEnd - AStart == 1) {
            return findMedianBaseCase(A[AStart], B, BStart, BEnd);
        } else if (BEnd - BStart == 1) {
            return findMedianBaseCase(B[BStart], A, AStart, AEnd);
        } else if (AEnd - AStart == 2) {
            return findMedianBaseCase2(A[AStart], A[AStart + 1], B, BStart, BEnd);
        } else if (BEnd - BStart == 2) {
            return findMedianBaseCase2(B[BStart], B[BStart + 1], A, AStart, AEnd);
        }
        
        int AMid = (AStart + AEnd) / 2;
        int BMid = (BStart + BEnd) / 2;
        //the number of numbers discarded in each list each time
        int k;
        
        if (A[AMid] <= B[BMid]) {
            //keep the neighbour when the size of the list that has a smaller median is even
            if ((AEnd - AStart) % 2 == 0) {
                k = Math.min(AMid - 1 - AStart, BEnd - BMid - 1);
            } else {
                k = Math.min(AMid - AStart, BEnd - BMid - 1);
            }
            return helper(A, AStart + k, AEnd, B, BStart, BEnd - k);
        } else {
            if ((BEnd - BStart) % 2 == 0) {
                k = Math.min(BMid - 1 - BStart, AEnd - AMid - 1);
            } else {
                k = Math.min(BMid - BStart, AEnd - AMid - 1);
            }
            return helper(A, AStart, AEnd - k, B, BStart + k, BEnd);
        }
    }
    
    public double findMedianSingleArray(int A[], int start, int end) {
        int mid = (start + end) / 2;
        if ((end - start) % 2 == 0) {
            return (A[mid] + A[mid - 1]) / 2.0;
        } else {
            return A[mid];
        }
    }
    
    public double findMedianBaseCase(int med, int A[], int start, int end) {
        int length = end - start;
        if (length == 1) {
            return (med + A[0]) / 2.0;
        }
        if (length % 2 == 0) {
            int a = A[length/2 - 1];
            int b = A[length/2];
            if (med <= a) {
                return a;
            } else if (med <= b) {
                return med;
            } else {
                return b;
            }
        } else {
            int a = A[length/2 - 1];
            int b = A[length/2];
            int c = A[length/2 + 1];
            if (med <= a) {
                return (a + b) / 2.0;
            } else if (med <= c) {
                return (med + b) / 2.0;
            } else {
                return (b + c) / 2.0;
            }
        }
    }
    
    public double findMedianBaseCase2(int med1, int med2, int C[], int start, int end) {
        //length >= 2 by default
        int n = end + start;
        int length = end - start;
        if (length % 2 == 0) {
        int a = (((n/2-2) >= 0) ? C[n/2 - 2] : Integer.MIN_VALUE);
        int b = C[n/2 - 1], c = C[n/2];
        int d = (((n/2 + 1) <= end-1) ? C[n/2 + 1] : Integer.MAX_VALUE);
        if (med2 <= b)
            return (b + Math.max(med2,a)) / 2.0;
        else if (med1 <= b)
            return (b + Math.min(med2,c)) / 2.0;
        else if (med1 >= c)
            return (c + Math.min(med1,d)) / 2.0;
        else if (med2 >= c)
            return (c + Math.max(med1,b)) / 2.0;
        else  /* a < med1 <= med2 < b */
            return (med1+med2) / 2.0;
        } else {
            int a = C[n/2 - 1], b = C[n/2], c = C[n/2 + 1];
            if (med1 >= b)
                return Math.min(med1, c);
            else if (med2 <= b)
                return Math.max(med2, a);
            else  /* med1 < b < med2 */
                return b;
        }
    }
}
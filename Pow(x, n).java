/*
Implement pow(x, n).
*/

public class Solution {
    public double pow(double x, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1/x;
        
        if (n % 2 == 0) {
            double temp = pow(x, n/2);
            return temp * temp;
        } else {
            double temp = pow(x, (n - 1)/2);
            return temp * temp * x;
        }
    }
}

//exceeds time limit
public class Solution {
    public double pow(double x, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        boolean neg = false;
        if (n == 0) return 1;
        if (n < 0) neg = true;
        
        n = Math.abs(n);
        double result = 1;
        int i = 1, k = 0;
        while (k < n) {
            double temp = x;
            for (i = 1; i * 2 <= n - k; i = i * 2) {
                temp *= temp;
            }
            k += i;
            result *= temp;
        }
        
        if (neg) return 1.0/result;
        else return result;
    }
}
/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/

public class Solution {
    public String getPermutation(int n, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        
        int[] index = new int[n];
        int i = 0;
        //IMPORTANT: there are k - 1 permutations before
        k = k - 1;
        while (k > 0) {
            index[i] = k / getFact(n - 1);
            k = k % getFact(n - 1);
            n--;
            i++;
        }
        
        String result = "";
        for (int j = 0; j < index.length; j++) {
            result += nums.get(index[j]);
            nums.remove(index[j]);
        }
        return result;
    }
    
    public int getFact(int x) {
        int result = 1;
        for (int i = x; i > 1; i--) {
            result *= i;
        }
        return result;
    }
}
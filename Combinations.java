/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (n <= 0 || k <= 0 || n < k) return result;
        
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> init = new ArrayList<Integer>();
            init.add(i);
            helper(init, n, k, result);
        }
        
        return result;
    }
    
    public void helper(ArrayList<Integer> cur, int n, int k, ArrayList<ArrayList<Integer>> result) {
        
        if (cur.size() == k) {
            result.add(cur);
            return;
        }
        int curMax = cur.get(cur.size() - 1);
        while (curMax < n) {
            ArrayList<Integer> res = new ArrayList<Integer>(cur);
            res.add(++curMax);
            helper(res, n, k, result);
        }
        
    }
}

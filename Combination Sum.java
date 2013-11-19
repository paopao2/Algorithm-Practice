/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (candidates.length == 0) return result;
        Arrays.sort(candidates);
        helper(candidates, new ArrayList<Integer>(), 0, 0, target, result);
        return result;
    }
    
    public void helper(int[] candidates, ArrayList<Integer> cur, int curIndex, int curSum, int target, ArrayList<ArrayList<Integer>> result) {
        if (curSum == target) {
            result.add(cur); 
        } else if (curSum < target) {
            for (int i = curIndex; i < candidates.length; i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(cur);
                temp.add(candidates[i]);
                helper(candidates, temp, i, curSum + candidates[i], target, result);
            }
        }
    }
}
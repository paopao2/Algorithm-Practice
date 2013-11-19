/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (candidates.length == 0) return result;
        Arrays.sort(candidates);
        helper(candidates, new ArrayList<Integer>(), -1, 0, target, result);
        return result;
    }
    
    public void helper(int[] candidates, ArrayList<Integer> cur, int curIndex, int curSum, int target, ArrayList<ArrayList<Integer>> result) {
        if (curSum == target) {
            result.add(cur); 
        } else if (curSum < target) {
            for (int i = curIndex + 1; i < candidates.length; i++) {
                if (i > curIndex + 1 && candidates[i] == candidates[i - 1]) continue;
                ArrayList<Integer> temp = new ArrayList<Integer>(cur);
                temp.add(candidates[i]);
                helper(candidates, temp, i, curSum + candidates[i], target, result);
            }
        }
    }
}
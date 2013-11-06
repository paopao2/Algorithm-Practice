/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        results.add(new ArrayList<Integer>());
        int index = 0;
        while (index < num.length) {
            int cur = num[index];
            //copy to current to get rid of concurrentModification exception
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>(results);
            for(ArrayList<Integer> arr : current) {
                ArrayList<Integer> newList = new ArrayList<Integer>(arr);
                newList.add(cur);
                if (!results.contains(newList)) {
                    results.add(newList);
                }
                
            }
            index ++;
        }
        return results;
    }
}
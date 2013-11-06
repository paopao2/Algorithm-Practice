/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return helper(num, num.length - 1);
    }
    
    public ArrayList<ArrayList<Integer>> helper(int[] num, int index) {
         ArrayList<ArrayList<Integer>> s = new ArrayList<ArrayList<Integer>>();
         if (index == 0) {
            ArrayList<Integer> init = new ArrayList<Integer>();
            init.add(num[0]);
            s.add(init);
            return s;
         }
         
         for (ArrayList<Integer> cur : helper(num, index - 1)) {
             for (int i = 0; i <= cur.size(); i++) {
                 ArrayList<Integer> temp = new ArrayList<Integer>(cur);
                 temp.add(i, num[index]);
                 s.add(temp);
             }
         }
         return s;
    }
}
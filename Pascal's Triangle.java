/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

*/

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0) {
            return result;
        }
        if (numRows == 1) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(1);
            result.add(list);
            return result;
        }
        ArrayList<ArrayList<Integer>> parentResult = generate(numRows - 1);
        ArrayList<Integer> parentList = parentResult.get(numRows - 2);
        ArrayList<Integer> curList = new ArrayList<Integer>();
        curList.add(1);
        for (int i = 1; i < numRows - 1; i++) {
            curList.add(parentList.get(i - 1) + parentList.get(i));
        }
        curList.add(1);
        // result = parentResult;
        // result.add(curList);
        parentResult.add(curList);
        return parentResult;
    }
}

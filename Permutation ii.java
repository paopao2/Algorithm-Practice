/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        permuteUnique(num, 0, result);
        return result;
    }
    
    public void permuteUnique(int[] num, int begin, ArrayList<ArrayList<Integer>> result) {
        if (begin == num.length) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int h = 0; h < num.length; h++) {
                list.add(num[h]);
            }
            result.add(list);
        }
        for (int end = begin; end < num.length; end++) {
            if (isSwap(num, begin, end)) {
                int temp = num[end];
                num[end] = num[begin];
                num[begin] = temp;
                
                permuteUnique(num, begin + 1, result);
                
                temp = num[end];
                num[end] = num[begin];
                num[begin] = temp;
            }
        }
    }
    
    public boolean isSwap(int[] arr, int i, int j) {
        for (int k = i; k < j; k++) {
            if (arr[k] == arr[j]) {
                return false;
            }
        }
        return true;
    }
}
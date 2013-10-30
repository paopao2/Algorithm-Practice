/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        
        for (int i = 0; i < num.length; i++) {
            if(i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < num.length; j++) {
                int cur = num[i] + num[j];
                int remainder = 0 - cur;
                if (findTarget(num, j + 1, num.length - 1, remainder)) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(num[i]);
                    temp.add(num[j]);
                    temp.add(remainder);
                    if (!result.contains(temp)) {
                        result.add(temp);
                    }
                    
                }
            }
        }
        
        return result;
    }
    
    public boolean findTarget(int[] num, int startIndex, int endIndex, int target) {
        if (startIndex < 0 || endIndex >= num.length || startIndex > endIndex || target < num[startIndex] || target > num[endIndex]) {
            return false;
        }
        
        while (startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex)/2;
            int cur = num[midIndex];
            if (cur == target) {
                return true;
            } else if (cur < target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }
        
        return false;
    }
}
/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int length = num.length;
        if (length < 4) {
            return result;
        }
        
        for (int i = 0; i < length - 3; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = length - 1; j >= 2 ; j--) {
                if (j != length - 1 && num[j] == num[j + 1]) {
                    continue;
                }
                int L = i + 1;
                int R = j - 1;
                int cur = num[i] + num[j];
                int remainder = target - cur;
                while (L < R) {
                    if (L != i + 1 && num[L] == num[L - 1]) {
                        L++;
                        continue;
                    } 
                    if (R != j - 1 && num[R] == num[R + 1]) {
                        R--;
                        continue;
                    }
                    int temp = num[L] + num[R];
                    if (temp == remainder) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[L]);
                        list.add(num[R]);
                        list.add(num[j]);
                        result.add(list);
                        L++;
                        R--;
                    } else if (temp < remainder) {
                        L++;
                    } else {
                        R--;
                    }
                }
            }
        }
        return result;
    }
}
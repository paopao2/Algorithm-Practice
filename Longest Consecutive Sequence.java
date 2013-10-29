/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

*/

public class Solution {
    public int longestConsecutive(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int length = num.length;
        
        //Key: value, Value: index
        HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        boolean[] visited = new boolean[length];
        
        for (int i = 0; i < length; i++) {
            numMap.put(num[i], i);
        }
        
        int maxLength = 0;
        for (int cur : numMap.keySet()) {
            int index = numMap.get(cur);
            if (visited[index]) {
                continue;
            }
            int curLength = 1;
            int left = cur - 1;
            int right = cur + 1;
            while (numMap.containsKey(left)) {
                int leftIndex = numMap.get(left);
                visited[leftIndex] = true;
                left --;
                curLength++;
            }
            while (numMap.containsKey(right)) {
                int rightIndex = numMap.get(right);
                visited[rightIndex] = true;
                right++;
                curLength++;
            }
            
            if (curLength > maxLength) {
                maxLength = curLength;
            }
        }
        
        return maxLength;
    }
}
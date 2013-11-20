/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/


//from right to left, find the first number that violates the increasing trend --> Partition Number
//from right to left, find the first number that is bigger than Partition Number --> Change Number
//swap Partition and Change Number
//reverse all the number on the right side of the partition index
public class Solution {
    public void nextPermutation(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int length = num.length;
        if (length == 0  || length == 1) return;
        
        int partitionIndex = length, changeIndex = length;
        for (int i = length - 1; i > 0; i--) {
            if (num[i] > num[i - 1]) {
                partitionIndex = i - 1;
                break;
            }
        }
        
        if (partitionIndex == length) {
            for (int i = 0; i < length/2; i++) {
                int temp = num[i];
                num[i] = num[length - 1 - i];
                num[length - 1 - i] = temp;
            }
        } else {
            for (int i = length - 1; i >= 0; i--) {
                if (num[i] > num[partitionIndex]) {
                    changeIndex = i;
                    int temp = num[changeIndex];
                    num[changeIndex] = num[partitionIndex];
                    num[partitionIndex]= temp;
                    break;
                }
            }
            if (changeIndex == length) {
                changeIndex = partitionIndex - 1;
                int temp = num[changeIndex];
                num[changeIndex] = num[partitionIndex];
                num[partitionIndex]= temp;
            } else {
                for (int i = partitionIndex + 1; i < (length + partitionIndex + 1)/2; i++) {
                    int temp = num[i];
                    num[i] = num[length + partitionIndex - i];
                    num[length + partitionIndex - i] = temp;
                }
            }
            
        }
        
    }
}
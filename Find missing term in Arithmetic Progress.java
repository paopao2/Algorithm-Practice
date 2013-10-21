/*
Task: Find the missing term in an Arithmetic Progression.
 
An Arithmetic Progression is defined as one in which there is a constant difference between the consecutive terms of a given series of numbers. You are provided with consecutive elements of an Arithmetic Progression. There is however one hitch: Exactly one term from the original series is missing from the set of numbers which have been given to you. The rest of the given series is the same as the original AP.  Find the missing term.  
 
 
Input Format
The first line contains an Integer N, which is the number of terms which will be provided as input.
This is followed by N consecutive Integers, with a space between each pair of integers. All of these are on one line, and they are in AP (other than the point where an integer is missing).
 
 
Output Format
One Number which is the missing integer from the series.
 
Sample Input
5
1 3 5 9 11  
 
Sample Output
7
 
Explanation
You are provided with 5 integers. As you can can observe, they have been picked from a series, in which the starting term is 1 and the common difference is 2. The only abberration, i.e. the missing term (7), occurs between 5 and 9. This is the missing element which you need to find.
 
Constraints
3 <= N <= 2500
All integers in the series will lie in the range [-10^6,+10^6].
*/

import java.io.*;
import java.util.Scanner;
public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        //FileReader fr = new FileReader("STDIN");
        //BufferedReader br = new BufferedReader(fr);
        Scanner in = new Scanner(System.in);
        
        String temp;
        String temp2;
        
        temp = in.nextLine();
        temp2 = in.nextLine();
        
        int totalNum = Integer.parseInt(temp);
        
        if(totalNum <= 3) {
            return;
        }
        
        String[] tempNums = temp2.split(" ");
      
        
        //parse the integer array
        int[] nums = new int[totalNum];
        for(int i = 0; i < totalNum; i++) {
            nums[i] = Integer.parseInt(tempNums[i]);
        }
        
        int SUM = (nums[0] + nums[totalNum - 1]) * (totalNum + 1)/ 2;
        
        for(int i = 0; i < totalNum; i++) {
            SUM -= nums[i];
        }
        
        System.out.println(SUM);
    }
}
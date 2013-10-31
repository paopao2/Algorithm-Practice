/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/

public class Solution {
    public int candy(int[] ratings) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (ratings == null) {
            return -1;
        }
        
        int length = ratings.length;
        if (length == 0) {
            return 0;
        }
        
        int[] candies = new int[length];
        candies[0] = 1;
        int sum = 1;
        
        for (int i = 1; i < length; i++) {

            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
                sum += candies[i];
            } else {
                //when ratings[i] < ratings[i - 1]
                if (candies[i - 1] > 1) {
                    candies[i] = 1;
                } else {
                    candies[i] = 1;
                    int k = i;
                    while (k > 0 && ratings[k] < ratings[k - 1] && candies[k - 1] <= candies[k]) {
                        candies[k - 1]++;
                        sum++;
                        k--;
                    }
                }
            }
        }
        
        return sum;
    }
}
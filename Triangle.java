public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        for (int i = triangle.size() - 2; i >= 0; i--) {
            ArrayList<Integer> preList = triangle.get(i + 1);
            ArrayList<Integer> curList = triangle.get(i);
            
            for (int j = 0; j < curList.size(); j++) {
                int sum1 = curList.get(j) + preList.get(j);
                int sum2 = curList.get(j) + preList.get(j + 1);
                
                curList.set(j, Math.min(sum1, sum2));
            }
        }
        return triangle.get(0).get(0);
    }
}

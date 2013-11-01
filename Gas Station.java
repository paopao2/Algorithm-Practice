public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int N = gas.length;
        
        int startIndex = 0;
        while (startIndex < N) {
        	
        	int filled = 0;
        	int required = 0;
            boolean found = true;

            for (int i = 0; i < N; i++) {
            	int k = i + startIndex;
            	if (k >= N) {
            		k -= N;
            	}
            	filled += gas[k];
            	required += cost[k];
            	if (required > filled) {
            		found = false;
            		break;
            	}
            }

            if (found) {
            	return startIndex;
            } else {
                filled = 0;
                required = 0;
            	startIndex++;
            }
        }

        return -1;
    }
}
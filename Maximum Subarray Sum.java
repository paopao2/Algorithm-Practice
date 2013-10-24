/*
Maximum sub array sum

use dynamic programming
*/

public int getMaximumSubarraySum(int[] arrays) {
	int maxSoFar = arrays[0];
	int maxAtCurrentPosition = arrays[1];

	for (int i = 1; i < arrays.length; i++) {
		if (maxAtCurrentPosition < 0) {
			maxAtCurrentPosition = arrays[i];
		} else {
			maxAtCurrentPosition += arrays[i];
		}

		if (maxAtCurrentPosition > maxSoFar) {
			maxSoFar = maxAtCurrentPosition;
		}
	}

	return maxSoFar;
}
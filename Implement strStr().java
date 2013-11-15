/*
Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack. 
*/

public class Solution {
    public String strStr(String haystack, String needle) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int length1 = haystack.length();
        int length2 = needle.length();
        if (length2 == 0) {
            return haystack;
        }
        if (length2 > length1) {
            return null;
        }
        
        for (int i = 0; i + length2 <= length1; i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }
            int k = i + 1;
            for (int j = 1; j < length2 && k < length1; j++) {
                if (needle.charAt(j) == haystack.charAt(k)) {
                    k++;
                } else {
                    break;
                }
            }
            if (k == i + length2) {
                return haystack.substring(i);
            }
        }
        return null;
    }
}

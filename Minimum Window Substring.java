/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

//O(N)
public class Solution {
    public String minWindow(String S, String T) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (S == null || T == null) return "";
        int length1 = S.length();
        int length2 = T.length();

        int[] needToFind = new int[256];
        for(char c : T.toCharArray()) {
            needToFind[c]++;
        }
        
        int[] hasFound = new int[256];
        
        int min = Integer.MAX_VALUE;
        String minWindow = "";
        int count = 0;
        for (int begin = 0, end = 0; end < length1; end++) {
            if (needToFind[S.charAt(end)] == 0) continue;
            
            hasFound[S.charAt(end)]++;
            if (hasFound[S.charAt(end)] <= needToFind[S.charAt(end)]) count++;
            
            if (count == length2) {
                while (needToFind[S.charAt(begin)] == 0 || hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)]) {
                    if (hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)]) hasFound[S.charAt(begin)]--;
                    begin++;
                }
                if (end - begin + 1 < min) {
                    min = end - begin + 1;
                    minWindow = S.substring(begin, end + 1);
                }
            }
            
        }
        return minWindow;
    }
}


//too slow
public class Solution {
    public String minWindow(String S, String T) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (S == null || T == null) return "";
        int length1 = S.length();
        int length2 = T.length();
        if (length1 < length2) return "";
        
        int min = Integer.MAX_VALUE;
        String minWindow = "";
        
        HashSet<Character> set = new HashSet<Character>();
        for (char c : T.toCharArray()) {
            set.add(c);
        }
        
        for (int i = 0; i + length2 <= length1; i++) {
            HashSet<Character> temp = new HashSet<Character>(set);
            int k = i;
            while (!temp.isEmpty()) {
                char c = S.charAt(k);
                if (temp.contains(c)) {
                    temp.remove(c);
                }
                k++;
                if (k >= length1) break;
            }
            if (k - i < min) {
                min = k - i;
                minWindow = S.substring(i, k);
            }
        }
        return minWindow;
    }
}


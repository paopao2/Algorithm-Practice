/*
You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/

public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        HashMap<String, Integer> mapL = new HashMap<String, Integer>();

        int singleWordSize = L[0].length();
        int LSize = L.length;
        
        int concatLength = LSize * singleWordSize;
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for(String s : L) {
            mapL.put(s, mapL.get(s) == null? 1 : (mapL.get(s) + 1));
        }
        
        for(int i = 0; i <= S.length() - concatLength; i++) {
            String s = S.substring(i, i + concatLength);
            HashMap<String, Integer> temp = new HashMap<String, Integer>(mapL);
            
            for(int j = 0; j < concatLength; j += singleWordSize) {
                String cur = s.substring(j, j + singleWordSize);
                if(temp.containsKey(cur)) {
                    if(temp.get(cur) == 1) {
                        temp.remove(cur);
                    }
                    else{
                        temp.put(cur, temp.get(cur) - 1);
                    }
                    
                }
                else {
                    break;
                }
                
            }
            if(temp.isEmpty()) {
                result.add(i);
            }
            
        }
        return result;
    }
}
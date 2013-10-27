/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
*/

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ArrayList<String> results = new ArrayList<String>();
        HashMap<String, ArrayList<String>> anagramsMap = new HashMap<String, ArrayList<String>>();
        
        for (int i = 0; i < strs.length; i++) {
            String cur = strs[i];
            char[] temp = cur.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            
            if (anagramsMap.containsKey(key)) {
                anagramsMap.get(key).add(cur);
            } else {
                ArrayList<String> newGroup = new ArrayList<String>();
                newGroup.add(cur);
                anagramsMap.put(key, newGroup);
            }
        }
        
        for (ArrayList<String> s : anagramsMap.values()) {
            if (s.size() > 1) {
                results.addAll(s);
            }
        }
        return results;
    }
}
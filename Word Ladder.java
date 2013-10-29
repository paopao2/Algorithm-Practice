/*
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Map<String, Boolean> visited = new HashMap<String, Boolean>();
        LinkedList<Count> queue = new LinkedList<Count>();
        queue.add(new Count(start, 1));
        visited.put(start, true);

        while (!queue.isEmpty()) {
        Count c = queue.poll();
        // for each character in the string, start new branches
        for (int i = 0; i < start.length(); i++) {
            StringBuilder sb = new StringBuilder(c.string);
            char sc = c.string.charAt(i);
            // for each different character as new node
            for (char cc = 'a'; cc <= 'z'; cc++) {
                if (cc == sc) continue;
                sb.setCharAt(i, cc);
                String tmp = sb.toString();
                // if we haven't visited this node and is in our dictionary
                // we visit this node
                if (visited.get(tmp) == null && dict.contains(tmp)) {
                    if (tmp.equals(end)) return c.count+1;
                    visited.put(tmp, true);
                    queue.add(new Count(tmp, c.count+1));
                }
            }
        }
    }
    return 0;
        
}
    
    class Count {
        //string
        String string;
        //the counts from start string to current string
        int count;
        
        public Count(String string, int count) {
            this.string = string;
            this.count = count;
        }
    }
}
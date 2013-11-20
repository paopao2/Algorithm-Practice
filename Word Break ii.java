/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/

//exceeds time limit
public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<String> result = new ArrayList<String>();
        if (s == null || s.equals("")) return result;
        helper(s, new StringBuilder(), result, 0, dict);
        return result;
    }
    
    public void helper(String s, StringBuilder sb, ArrayList<String> result, int curIndex, Set<String> dict) {
        if (curIndex == s.length()) result.add(sb.toString());
        else if (curIndex < s.length()) {
            for (int i = curIndex; i <= s.length(); i++) {
                if (dict.contains(s.substring(curIndex, i))) {
                    StringBuilder cur = new StringBuilder(sb);
                    if (cur.length() == 0) {
                        cur.append(" ");
                    }
                    cur.append(s.substring(curIndex, i));
                    helper(s, cur, result, i, dict);
                }
            }
        }
        
    }
}

//DP
public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        if (s == null || dict.size() <= 0) {
            return result;
        }
        int length = s.length();
        // seg[i, j] means substring t start from i to j can be segmented into dictionary words
        boolean[][] seg = new boolean[length][length + 1];
        seg[0][0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dict.contains(s.substring(j, i))) {
                    seg[j][i] = true;
                } else {
                    for (int k = j; k <= i - 1; k++) {
                        if (seg[j][k] && seg[k][i]) {
                            seg[j][i] = true;
                            break;
                        }
                    }
                }
            }
        }
        if (!seg[0][length]) {
            return result;
        }

        dfs(s, seg, 0, result, new StringBuffer(), dict);

        return result;
    }

    private void dfs(String s, boolean[][] seg, int start, ArrayList<String> result, StringBuffer sb, Set<String> dict) {
        if (start == s.length()) {
            result.add(sb.toString());
        } else if (start < s.length()) {
            for (int end = start; end <= s.length(); end++) {
                if (seg[start][end]) {
                    String next = s.substring(start, end);
                    if (!dict.contains(next)) continue;
                    StringBuffer temp = new StringBuffer(sb);
                    if (temp.length() != 0) temp.append(" ");
                    temp.append(next);
                    dfs(s, seg, end, result, temp, dict);
                }
            }
        }
    }
}
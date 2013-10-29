/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/

public class Solution {
    public String simplifyPath(String path) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        StringBuilder s = new StringBuilder(path);
	        
        String cleanPath = s.toString();
        String[] paths = cleanPath.split("/");
        
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].equals(".") || paths[i].length() == 0) {
                
            } else if (paths[i].equals("..")) {
                //remove previous path location
                if (result.isEmpty()) {
                    continue;
                }
                //System.out.println("REMOVE:  " + result.get(result.size() - 1));
                result.remove(result.size() - 1);
                
            } else {
            	//System.out.println("ADD:  " + paths[i]);
                result.add(paths[i]);
            }
        }
        
        if (result.isEmpty()) {
            return "/";
        }
        
        StringBuilder finalPath = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).length() != 0) {
                finalPath.append("/");
                finalPath.append(result.get(i));
            }
        }
        if (finalPath.length() > 0) {
            return finalPath.toString();
        } else {
            return "/";
        }
    
        
        
    }
}
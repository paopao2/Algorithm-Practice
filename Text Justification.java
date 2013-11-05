public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ArrayList<String> result = new ArrayList<String>();
        if (L == 0) {
            result.add("");
            return result;
        }
        for (int i = 0; i < words.length;) {
            String curLine = "";
            int curLength = 0;
            int wordCount = 0;
            while (i < words.length && curLength + words[i].length() <= L) {
                //each word padded with a space
                curLength += words[i].length() + 1;
                //each word get a space
                curLine = curLine + words[i] + " ";
                wordCount++;
                i++;
            }
            
            //get rid of the last padding space
            curLine = curLine.substring(0, curLine.length() - 1);
            curLength--;
            
            if (wordCount == 1 || i == words.length) {
                while (curLength < L) {
                    curLine += " ";
                    curLength++;
                }
                result.add(curLine);
            } else {
                int extraSpace = L - curLength;
                if (extraSpace == 0) {
                    result.add(curLine);
                } else {
                    int extraSpacePerWord = extraSpace / (wordCount - 1);
                    int spacesLeft = extraSpace % (wordCount - 1);
                    String spacePerWord = " ";
                    while (extraSpacePerWord > 0) {
                        spacePerWord += " ";
                        extraSpacePerWord--;
                    }
                     
                    String[] w = curLine.split(" ");
                    String s = w[0];
                    for(int j = 1; j < w.length; j++) {
                        if(spacesLeft > 0) {
                            s = s + spacePerWord + " " + w[j];
                            spacesLeft--;
                        } else {
                            s = s + spacePerWord + w[j];
                        }
                    }
                    result.add(s);
                }
            }
        }
        return result;
    }
}
/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) return result;
        Comparator<Interval> comparator = new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if (i1.start < i2.start) {
                    return -1;
                } else if (i1.start > i2.start) {
                    return 1;
                } else {
                    if (i1.end < i2.end) return -1;
                    else if (i1.end > i2.end) return 1;
                    else return 0;
                }
            }
        };
        
        Collections.sort(intervals, comparator);
        
        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (result.isEmpty()) result.add(cur);
            else {
                Interval last = result.get(result.size() - 1);
                if (last.end >= cur.start) {
                    last.end = Math.max(last.end, cur.end);
                } else {
                    result.add(cur);
                }
            }
        }
        return result;
    }
}
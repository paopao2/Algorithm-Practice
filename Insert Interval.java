/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Interval> result = new ArrayList<Interval>(intervals);
        if (intervals == null || intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }
        int m = 0;
        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.end < newInterval.start) continue;
            if (cur.start > newInterval.end) {
                result.add(i - m, newInterval);
                return result;
            }
            if (cur.start <= newInterval.start && cur.end >= newInterval.end) return result;
            
            //newInterval contain current interval
            if (cur.start > newInterval.start && cur.end < newInterval.end) {
                result.remove(cur);
                m++;
                continue;
            }
            //merge
            if (cur.end >= newInterval.start) {
                newInterval.start = Math.min(cur.start, newInterval.start);
                result.remove(cur);
                m++;
            }
            if (cur.start <= newInterval.end) {
                newInterval.end = Math.max(newInterval.end, cur.end);
                if (result.contains(cur)) {
                    result.remove(cur);
                    m++;
                }
            }
            
        }
        result.add(newInterval);
        return result;
    }
}
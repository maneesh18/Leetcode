/*
You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei]. The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will receive a value of valuei. You can choose at most two non-overlapping events to attend such that the sum of their values is maximized.

Return this maximum sum.

Note that the start time and end time is inclusive: that is, you cannot attend two events where one of them starts and the other ends at the same time. More specifically, if you attend an event with end time t, the next event must start at or after t + 1.


*/

class Solution {
    public int nextMaxEvent(int l, int r, int end, int[] sufMax, int[][] events) {
        int max = 0;
        while(l<=r) {
            int m = l + (r-l)/2;
            if(events[m][0] > end) {
                max = sufMax[m];
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return max;
    }
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> Integer.compare(a[0],b[0]));
        int n = events.length;
        int[] sufMax = new int[n];
        sufMax[n-1] = events[n-1][2];
        for(int i=n-2;i>=0;i--)
            sufMax[i] = Math.max(sufMax[i+1], events[i][2]);
        int ans=0;
        for(int i=0;i<n;i++) {
            int sum = events[i][2];
            sum += nextMaxEvent(i+1, n-1, events[i][1], sufMax, events);
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}

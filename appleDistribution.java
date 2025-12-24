/*
You are given an array apple of size n and an array capacity of size m.

There are n packs where the ith pack contains apple[i] apples. There are m boxes as well, and the ith box has a capacity of capacity[i] apples.

Return the minimum number of boxes you need to select to redistribute these n packs of apples into boxes.

Note that, apples from the same pack can be distributed into different boxes.


*/



class Solution {
    public int minimumBoxes(int[] apple, int[] cap) {
        int sum = Arrays.stream(apple).sum();

        int[] fq = new int[51];
        int high = 0, low = 51;
        for (int c : cap) {
            fq[c]++;
            high = Math.max(high, c);
            low = Math.min(low, c);
        }

        int res = 0;
        for (int i = high; i >= low && sum > 0; i--) {
            while (fq[i]-- > 0 && sum > 0) {
                sum -= i;
                res++;
            }
        }

        return res;
    }
}

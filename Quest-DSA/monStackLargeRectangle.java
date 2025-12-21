/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack();
        st.push(-1);
        int max = 0;
        for(int i = 0;i < heights.length;i++){
            while(st.peek() != -1 && heights[i] <= heights[st.peek()]){
                int height = heights[st.pop()];
                int width = i - st.peek() - 1;
                max = Math.max(max, height * width);
            }
            st.push(i);
        }
        while(st.peek() != -1){
            int height = heights[st.pop()];
            int width = heights.length - st.peek() - 1;
            max = Math.max(max, height * width);
        }
        return max;
    }
}

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 1, n = citations.length;
        int max = 0;
        for(int i = n -1 ; i >= 0; i--){
            if(citations[i] >= h)
                max = h;
            h++;
        }
        return max;
    }
}

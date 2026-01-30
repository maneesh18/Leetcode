class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[1] != b[1])
                    return Integer.compare(a[1],b[1]);
                return Integer.compare(a[0], b[0]);
            }
        });
        int prev = points[0][1], count = 1;
        for(int i = 1; i < points.length;i++){
            if(prev < points[i][0]){
                count++;
                prev = points[i][1];
            }
        }
        return count;
    }
}

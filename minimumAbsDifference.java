class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList();
        int min = 1000000000;
        for(int i = 1;i < arr.length;i++){
            int diff = arr[i] - arr[i-1];
            if(diff < min){
                min = diff;
                // System.out.println("<");
                ans = new ArrayList();
                ans.add(List.of(arr[i-1], arr[i]));
            }else if(diff == min){
                // System.out.println("=");
                ans.add(List.of(arr[i-1], arr[i]));
            }
        }
        return ans;
    }
}

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> l=new ArrayList<>(); 
        for(int i=0;i<nums.length;i++){
            int st=nums[i];
            int end=nums[i];
            while(i+1< nums.length && nums[i+1]==(end+1)){
                end=end+1;
                i++;
            }
            if(st!=end && end<=Integer.MAX_VALUE && st>=Integer.MIN_VALUE && end>Integer.MIN_VALUE)
                l.add(String.valueOf(st+"->"+end));
            else
                l.add(String.valueOf(st));
        }
        return l;
    }
}

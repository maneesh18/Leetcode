class Solution {
    public int longestBalanced(String s) {
        int ans = 1;
        for(int i=0;i<s.length();i++){
            int[] arr = new int[26];
            for(int j=i;j<s.length();j++){
                char ch = s.charAt(j);
                arr[ch-'a']++;
                if(isArrayBalanced(arr)) ans = Math.max(ans, j-i+1);
            }
        }
    return ans;
    }
    public boolean isArrayBalanced(int[] arr){
        int value = -1;
        for(int i : arr){
            if(i!=0 && value==-1) value = i;
            else if(i!=0 && i!=value) return false; 
        }
    return true;
    }
}

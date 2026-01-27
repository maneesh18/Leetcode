class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();
        char[] ch = s.toCharArray();
        int start = 0, ans = 0;
        for(int i = 0; i < ch.length;i++){
            while(map.containsKey(ch[i])){
                ans = Math.max(ans, i - start);
                map.remove(ch[start++]);
            }
            map.put(ch[i], i);
        }
        ans = Math.max(ans, ch.length - start);
        return ans;
    }
}

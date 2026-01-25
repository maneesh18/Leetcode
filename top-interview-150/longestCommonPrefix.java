class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        char[] pref = strs[0].toCharArray();
        int prefLen = pref.length;

        for (int i = 1; i < strs.length; i++) {
            prefLen = Math.min(prefLen, strs[i].length());
            int j = 0;
            for(; j < prefLen;j++){
                if(pref[j] != strs[i].charAt(j))
                    break;
            }
            if(j == 0)
                return "";
            prefLen = j;
        }
        return strs[0].substring(0,prefLen);
    }
}

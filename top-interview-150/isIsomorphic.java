class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character,Character> map = new HashMap();
        Set<Character> set = new HashSet();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for(int i = 0 ; i< sArr.length;i++){
            if(map.containsKey(sArr[i])){
                if(map.get(sArr[i]) != tArr[i])
                    return false;
                continue;
            }
            if(set.contains(tArr[i]))
                return false;
            map.put(sArr[i], tArr[i]);
            set.add(tArr[i]);
        }
        return true;
    }
}

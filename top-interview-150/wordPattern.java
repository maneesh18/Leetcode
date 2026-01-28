class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length)
            return false;
        Map<Character,String> map = new HashMap();
        Set<String> set = new HashSet();
        char[] sArr = pattern.toCharArray();
        for(int i = 0 ; i< sArr.length;i++){
            if(map.containsKey(sArr[i])){
                if(!(map.get(sArr[i])).equals(arr[i]))
                    return false;
                continue;
            }
            if(set.contains(arr[i]))
                return false;
            map.put(sArr[i], arr[i]);
            set.add(arr[i]);
        }
        return true;
    }
}


class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() ==0)
            return true;
        if(s.length() > t.length())
            return false;
        int i=0,j=0;
        while(j<s.length() && i<t.length()){
            if(t.charAt(i) == s.charAt(j))
                j++;
            i++;
        }
        return j==s.length();
    }
}

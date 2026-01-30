class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character,Character> map = new HashMap();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else if(st.isEmpty())
                return false;
            else if(map.get(ch) != st.pop())
                return false;
        }
        return st.isEmpty();
    }
}

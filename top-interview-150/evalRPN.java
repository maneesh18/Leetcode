class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack();
        int a,b;
        for(String token : tokens){
            switch(token){
                case "+" : a = st.pop();b = st.pop();
                    st.push(b+a);
                    break;
                case "-" : a = st.pop();b = st.pop();
                    st.push(b-a);
                    break;
                case "*" : a = st.pop();b = st.pop();
                    st.push(b*a);
                    break;
                case "/" : a = st.pop();b = st.pop();
                    st.push(b/a);
                    break;
                default:st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}

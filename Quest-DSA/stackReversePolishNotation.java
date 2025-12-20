/*
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.
*/


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

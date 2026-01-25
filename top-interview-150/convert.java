class Solution {
    public String convert(String s, int numRows) {
        int n = s.length(),i = 0;
        StringBuilder[] arr = new StringBuilder[numRows];
        for (int k = 0; k < numRows; k++) 
            arr[k] = new StringBuilder();
        char[] ch = s.toCharArray();
        while(i < n){
            arr[0].append(ch[i++]);
            for(int j = 1; (j + 1 < numRows && i < n);j++)
                arr[j].append(ch[i++]);
            if(i < n)
                arr[numRows - 1].append(ch[i++]);
            for(int j = numRows - 2; (j >= 1 && i < n);j--)
                arr[j].append(ch[i++]);
        }
        StringBuilder ans = new StringBuilder();
        for(StringBuilder temp : arr)
            ans.append(temp);
        return ans.toString();
    }
}

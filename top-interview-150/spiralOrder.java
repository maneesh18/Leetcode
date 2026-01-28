class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        List<Integer> ans = new ArrayList();
        while(top <= bottom && left <= right){
            int i = left;
            while(i<=right)
                ans.add(matrix[top][i++]);
            top++;
            i = top;
            while(i <= bottom)
                ans.add(matrix[i++][right]);
            right--;
            i = right;
            if (top <= bottom) {
                while(i >= left)
                    ans.add(matrix[bottom][i--]);
                bottom--;
            }
            i = bottom;
            if (left <= right) {
                while(i >= top)
                    ans.add(matrix[i--][left]);
                left++;
            }
        }
        return ans;
    }
}

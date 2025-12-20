/*
You are given an array of n strings strs, all of the same length.

The strings can be arranged such that there is one on each line, making a grid.

For example, strs = ["abc", "bce", "cae"] can be arranged as follows:
abc
bce
cae
You want to delete the columns that are not sorted lexicographically. In the above example (0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') are sorted, while column 1 ('b', 'c', 'a') is not, so you would delete column 1.

Return the number of columns that you will delete.
*/

class Solution {
    public int minDeletionSize(String[] strs) {
        // String length.
        int K = strs[0].length();

        // Variable to store the count of columns to be deleted.
        int res = 0;
        // Iterate over each index in the string.
        for (int col = 0; col < K; col++) {
            // Iterate over the strings.
            for (int row = 1; row < strs.length; row++) {
                // Characters should be in increasing order, 
                // If not, increment the counter.
                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    res++;
                    break;
                }
            }
        }

        return res;
    }
}

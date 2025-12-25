/*
You are given an array target of n integers. From a starting array arr consisting of n 1's, you may perform the following procedure :

let x be the sum of all elements currently in your array.
choose index i, such that 0 <= i < n and set the value of arr at index i to x.
You may repeat this procedure as many times as needed.
Return true if it is possible to construct the target array from arr, otherwise, return false.
*/

class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        int sum = target.length;
        for(int x : target)
            pq.add(x);
        while(!pq.isEmpty()){
            if(sum > pq.peek())
                return false;
            else if(sum == pq.peek())
                pq.poll();
            sum += sum - 1;
        }
        return true;
    }
}

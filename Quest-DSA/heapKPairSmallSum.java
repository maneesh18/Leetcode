/*
You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.

Define a pair (u, v) which consists of one element from the first array and one element from the second array.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
*/

import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        for(int i = 0; i < Math.min(nums1.length, k); i++)
            pq.offer(new int[]{nums1[i] + nums2[0], i, 0});

        while(!pq.isEmpty() && res.size() < k) {
            int [] cur = pq.poll();
            int i = cur[1], j = cur[2];

            res.add(Arrays.asList(nums1[i], nums2[j]));

            if(j + 1 < nums2.length)
                pq.offer(new int[]{nums1[i] + nums2[j+1], i, j+1});
        }

        return res;
    }
}

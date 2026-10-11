// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/qheap1/problem?isFullScreen=true
// Problem     QHEAP1
// Difficulty  Easy
// Subdomain   Heap
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-10-11, 05:31 p.m.
// ──────────────────────────────────────────────────


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        int q = sc.nextInt();

        while (q-- > 0) {
            int type = sc.nextInt();

            if (type == 1) {
                int x = sc.nextInt();
                pq.add(x);
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            } else if (type == 2) {
                int x = sc.nextInt();
                freq.put(x, freq.get(x) - 1);

                if (freq.get(x) == 0) {
                    freq.remove(x);
                }
            } else if (type == 3) {
                while (!pq.isEmpty() && !freq.containsKey(pq.peek())) {
                    pq.poll();
                }
                System.out.println(pq.peek());
            }
        }

        sc.close();
    }
}

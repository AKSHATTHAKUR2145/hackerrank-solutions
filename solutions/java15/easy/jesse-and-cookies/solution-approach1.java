// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/jesse-and-cookies/problem?isFullScreen=true
// Problem     Jesse and Cookies
// Difficulty  Easy
// Subdomain   Heap
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-10-11, 05:33 p.m.
// ──────────────────────────────────────────────────


import java.util.*;

class Result {
    public static int cookies(int k, List<Integer> A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(A);

        int operations = 0;

        while (!pq.isEmpty() && pq.peek() < k) {
            if (pq.size() < 2) {
                return -1;
            }

            int first = pq.poll();
            int second = pq.poll();

            int combined = first + 2 * second;
            pq.offer(combined);

            operations++;
        }

        return operations;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> A = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            A.add(sc.nextInt());
        }

        System.out.println(Result.cookies(k, A));

        sc.close();
    }
}

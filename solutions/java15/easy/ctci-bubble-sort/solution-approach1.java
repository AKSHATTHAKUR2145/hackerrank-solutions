// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/ctci-bubble-sort/problem?isFullScreen=true
// Problem     Sorting: Bubble Sort
// Difficulty  Easy
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-08-10, 03:44 p.m.
// ──────────────────────────────────────────────────

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static void countSwaps(List<Integer> a) {
 int n = a.size();
    int numSwaps = 0;

    for (int i = 0; i < n; i++) {

        for (int j = 0; j < n - 1; j++) {

            if (a.get(j) > a.get(j + 1)) {

                // Swap
                int temp = a.get(j);
                a.set(j, a.get(j + 1));
                a.set(j + 1, temp);

                numSwaps++;
            }
        }
    }

    System.out.println("Array is sorted in " + numSwaps + " swaps.");
    System.out.println("First Element: " + a.get(0));
    System.out.println("Last Element: " + a.get(n - 1));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.countSwaps(a);

        bufferedReader.close();
    }
}

// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/ctci-merge-sort/problem?isFullScreen=true
// Problem     Merge Sort: Counting Inversions
// Difficulty  Hard
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-09-27, 08:48 p.m.
// ──────────────────────────────────────────────────

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countInversions' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static long countInversions(List<Integer> arr) {

        int[] a = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            a[i] = arr.get(i);
        }

        int[] temp = new int[a.length];

        return mergeSort(a, temp, 0, a.length - 1);
    }

    // Merge Sort
    private static long mergeSort(int[] a, int[] temp, int left, int right) {

        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        long count = 0;

        // Count inversions in left half
        count += mergeSort(a, temp, left, mid);

        // Count inversions in right half
        count += mergeSort(a, temp, mid + 1, right);

        // Count inversions while merging
        count += merge(a, temp, left, mid, right);

        return count;
    }

    // Merge two sorted halves and count inversions
    private static long merge(int[] a, int[] temp,
                              int left, int mid, int right) {

        int i = left;
        int j = mid + 1;
        int k = left;

        long inversions = 0;

        while (i <= mid && j <= right) {

            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];

                // Every remaining element in the left half
                // forms an inversion with a[j]
                inversions += (mid - i + 1);
            }
        }

        // Remaining elements of left half
        while (i <= mid) {
            temp[k++] = a[i++];
        }

        // Remaining elements of right half
        while (j <= right) {
            temp[k++] = a[j++];
        }

        // Copy sorted elements back
        for (i = left; i <= right; i++) {
            a[i] = temp[i];
        }

        return inversions;
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter =
                new BufferedWriter(
                        new FileWriter(System.getenv("OUTPUT_PATH"))
                );

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {

            try {

                int n = Integer.parseInt(
                        bufferedReader.readLine().trim()
                );

                List<Integer> arr = Stream.of(
                        bufferedReader.readLine()
                                .replaceAll("\\s+$", "")
                                .split(" ")
                )
                .map(Integer::parseInt)
                .collect(toList());

                long result = Result.countInversions(arr);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

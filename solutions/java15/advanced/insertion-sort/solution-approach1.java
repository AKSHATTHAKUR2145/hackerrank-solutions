// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/insertion-sort/problem?isFullScreen=true
// Problem     Insertion Sort Advanced Analysis
// Difficulty  Advanced
// Subdomain   Sorting
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-09-04, 01:32 a.m.
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

    public static long insertionSort(List<Integer> arr) {
        int[] nums = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            nums[i] = arr.get(i);
        }

        return mergeSort(nums, 0, nums.length - 1);
    }

    public static long mergeSort(int[] arr, int si, int ei) {

        if (si >= ei) {
            return 0;
        }

        int mid = si + (ei - si) / 2;

        long count = 0;

        count += mergeSort(arr, si, mid);
        count += mergeSort(arr, mid + 1, ei);
        count += merge(arr, si, mid, ei);

        return count;
    }

    public static long merge(int[] arr, int si, int mid, int ei) {

        int[] temp = new int[ei - si + 1];

        int i = si;
        int j = mid + 1;
        int k = 0;

        long shifts = 0;

        while (i <= mid && j <= ei) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];

                shifts += (long) (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for (i = 0, k = si; i < temp.length; i++, k++) {
            arr[k] = temp[i];
        }

        return shifts;
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter =
                new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

                long result = Result.insertionSort(arr);

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

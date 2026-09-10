// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/quicksort1/problem?isFullScreen=true
// Problem     Quicksort 1 - Partition
// Difficulty  Easy
// Subdomain   Sorting
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-09-10, 11:21 p.m.
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

   

    public static List<Integer> quickSort(List<Integer> arr) {

        int pivot = arr.get(0);

        List<Integer> left = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int num : arr) {

            if (num < pivot) {
                left.add(num);
            } 
            else if (num == pivot) {
                equal.add(num);
            } 
            else {
                right.add(num);
            }
        }

        List<Integer> result = new ArrayList<>();

        result.addAll(left);
        result.addAll(equal);
        result.addAll(right);

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(System.in)
        );

        BufferedWriter bufferedWriter = new BufferedWriter(
            new FileWriter(System.getenv("OUTPUT_PATH"))
        );

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(
                bufferedReader.readLine()
                    .replaceAll("\\s+$", "")
                    .split(" ")
            )
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.quickSort(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

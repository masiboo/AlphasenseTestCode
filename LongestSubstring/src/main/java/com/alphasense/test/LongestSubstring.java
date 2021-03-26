package com.alphasense.test;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static void main( String[] args )
    {
        Pair<Integer, String> result = getLongestSubstring("pwwkew");
        System.out.println("Longest substring: "+result.getValue()+"\nLongest substring lenght: "+result.getKey());
    }

    // we are traversing the string only once, the time complexity will be linear, or O(n).
    public static Pair<Integer, String> getLongestSubstring(String input) {
        Map<Character, Integer> found = new HashMap<>();
        String output = "";
        for (int start = 0, end = 0; end < input.length(); end++) {
            char currChar = input.charAt(end);
            if (found.containsKey(currChar)) {
                // increase start index if already found a character
                start = Math.max(found.get(currChar) + 1, start);
            }
            if (output.length() < end - start + 1) {
                output = input.substring(start, end + 1);
            }
            found.put(currChar, end);
        }
        return new Pair<>(output.length(), output);
    }
}

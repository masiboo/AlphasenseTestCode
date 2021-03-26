package com.alphasense.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class LongestSubstringTest
{

    @Test
    void getLongestSubstringTest() {
        assertEquals("abc", LongestSubstring.getLongestSubstring("abcabcbb").getValue());
        assertEquals(3, LongestSubstring.getLongestSubstring("abcabcbb").getKey());
        assertEquals("b", LongestSubstring.getLongestSubstring("bbbbb").getValue());
        assertEquals(1, LongestSubstring.getLongestSubstring("bbbbb").getKey());
        assertEquals("wke", LongestSubstring.getLongestSubstring("pwwkew").getValue());
        assertEquals(3, LongestSubstring.getLongestSubstring("pwwkew").getKey());
    }
}

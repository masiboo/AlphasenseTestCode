package com.alphasense.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SubArraySumTest {

    @Test
    void subArraySumTrueTest() {
        SubArraySum subArraySum = new SubArraySum();
        int arr[] = {1, 2, 3, 4};
        int sum = 7;
        assertTrue(subArraySum.subArraySum(arr, sum));
    }

    @Test
    void subArraySumFalseTest() {
        SubArraySum subArraySum = new SubArraySum();
        int arr[] = {1, 2, 3, 4};
        int sum = 20;
        assertFalse(subArraySum.subArraySum(arr, sum));
    }
}
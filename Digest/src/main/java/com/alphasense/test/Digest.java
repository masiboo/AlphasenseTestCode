package com.alphasense.test;

import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public abstract class Digest {
    // Issue 1:  Any array can't work properly as a key in a HashMap, since arrays don't override equals.
    // So two arrays will be considered equal only if they refer to the same object.
    private Map<byte[], byte[]> cache = new HashMap<byte[], byte[]>();

    public byte[] digest(byte[] input)  {
        // Issue 2: here it tries to get value from the map using array as key.
        // By Java syntax, it is correct since map.get() takes an object as a key.
        // But it will definitely return null.
        byte[] result = cache.get(input);
        if (result == null) {
            synchronized (cache) {
                // Issue 3: Same as issue 2.
                result = cache.get(input);
                if (result == null) {
                    try {
                       // it is not an issue, most probably some superclass has to extend this class
                        // and implement the abstract method.
                        result = doDigest(input);
                        cache.put(input, result);
                    } catch (RuntimeException ex) {
                        LoggerFactory.getLogger("Digest").error(
                                "Unable to make digest"
                        );
                        // Coding recommendation: If any method is throwing an exception, it is recommended to add in the signature
                        //  In this case public byte[] digest(byte[] input throws RuntimeException
                        throw ex;
                    }
                }
            }
        }
        return result;
    }
    protected abstract byte[] doDigest(byte[] input);
}
package com.javaexamples;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

/**
 * Created by smani on 8/5/16.
 */
public class RecurFib {

    private static Map<Long, BigInteger> results = new HashMap<>();

    public static void main(String[] args) {
        final Stopwatch stopwatch = Stopwatch.createStarted();
        for (long i = 0; i <= 50; i++) {
            System.out.println("Fib(" + i +")->" + getMemorizedFib(i));
        }
        System.out.println("Elapsed time in Seconds ==> " + stopwatch.elapsed(TimeUnit.SECONDS));

    }

    public static long getFib(long n) {
        if  (n <= 1) {
            return n;
        } else {
            return getFib(n- 1) + getFib(n-2);
        }
    }
    
    public static BigInteger getMemorizedFib(long n) {
        if  (n <= 1) {
            return new BigInteger(String.valueOf(n));
        } else {
            return results.computeIfAbsent(n,  x-> getMemorizedFib(n- 1).add(getMemorizedFib(n-2)));
        }
    }
    
}

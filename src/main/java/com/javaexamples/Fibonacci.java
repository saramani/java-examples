package com.javaexamples;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

/**
 * Created by smani on 8/5/16.
 */
public class Fibonacci {

	private static Map<Long, BigInteger> results = new HashMap<>();

	public static void main(String[] args) {
		final Stopwatch stopwatch = Stopwatch.createStarted();
		for (long i = 0; i <= 20; i++) {
			System.out.println("Fib(" + i + ")->" + fib(i));
		}
		System.out.println("Elapsed time in Seconds ==> " + stopwatch.elapsed(TimeUnit.SECONDS));

	}

	public static long getRecurFib(long n) {
		if (n <= 1) {
			return n;
		} else {
			return getRecurFib(n - 1) + getRecurFib(n - 2);
		}
	}

	public static BigInteger getMemorizedFib(long n) {
		if (n <= 1) {
			return BigInteger.valueOf(n);
		} else {
			return results.computeIfAbsent(n, x -> getMemorizedFib(n - 1).add(getMemorizedFib(n - 2)));
		}
	}

	public static BigInteger getSwapFib(long n) {
		if (n <= 1) {
			return BigInteger.valueOf(n);
		}

		BigInteger fibNMinus1 = BigInteger.valueOf(1);
		BigInteger fibNMinus2 = BigInteger.valueOf(0);
		BigInteger fib = BigInteger.valueOf(0);

		for (long i = 2; i <= n; i++) {
			fib = fibNMinus1.add(fibNMinus2);
			fibNMinus2 = fibNMinus1;
			fibNMinus1 = fib;
		}
		return fib;
	}
	
	public static long fib(long n) {

		
		long fib1 = 0;
		long fib2 = 1;
		long fib = 0;
		
		for (int i = 0;i < n; i++) {
			fib = fib1 + fib2;
			fib2 = fib1;
			fib1 = fib;
		}
		
		return fib;
		
	}

}

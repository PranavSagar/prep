package com.recursion.implementationProblems;

public class powXN {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            return 1 / myPow(x, -n); // Handle negative exponent
        }
        double half = myPow(x, n / 2); // Recursive call for n/2
        if (n % 2 == 0) {
            return half * half; // If n is even, return (x^(n/2))^2
        } else {
            return half * half * x; // If n is odd, return (x^(n/2))^2 * x
        }
    }

    public static void main(String[] args) {
        powXN solution = new powXN();
        double result = solution.myPow(2.0, 10);
        System.out.println("2.0^10 = " + result); // Expected output: 1024.0
    }
}

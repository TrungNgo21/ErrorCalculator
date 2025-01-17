package org.example;

public class Calculator {
  // Basic operators
  public String add(int a, int b) {
    return Integer.toString(a + b);
  }

  public String subtract(int a, int b) {

    return Integer.toString(a - b);
  }

  public String multiply(int a, int b){
    return Integer.toString(a * b);
  }

  public String divide(int a, int b) {
    if (b == 0) {
      throw new ArithmeticException("Division by zero is not allowed");
    }
    return String.valueOf(((double) a / (double) b));
  }

  public String modulo(int a, int b) {
    if (b == 0) {
      throw new ArithmeticException("Modulo by zero is not allowed");
    }
    return String.valueOf(a % b);
  }

  public String power(int base, int exponent) {
    if (exponent < 0) {
      throw new IllegalArgumentException("Exponent must be non-negative");
    }
    if (exponent == 0) {
      return String.valueOf(1);
    }
    long result = 1;
    for (int i = 0; i < exponent; i++) {
      result *= base;
    }
    return String.valueOf(result);
  }

  // Advanced operators
  public String gcd(int a, int b) {
    a = abs(a);
    b = abs(b);
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return String.valueOf(a);
  }

  public String lcm(int a, int b) {
    if (a == 0 || b == 0) {
      return "0";
    }

    long absA = abs(a);
    long absB = abs(b);

    // Calculate GCD first
    long gcdValue = Long.parseLong(gcd(a, b));
    long lcm = (absA / gcdValue) * absB;

    return Long.toString(lcm);
  }

  public String fibonacci(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Input must be non-negative");
    }
    if (n <= 1) {
      return Integer.toString(n);
    }

    long a = 0, b = 1;
    for (int i = 2; i <= n; i++) {
      long temp = a + b;
      a = b;
      b = temp;
    }
    return Long.toString(b);
  }

  // Helper method to calculate absolute value without using Math.abs
  private int abs(int n) {
    return n < 0 ? -n : n;
  }
}

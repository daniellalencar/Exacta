package com.exacta.question3;

public class Solution3 {
  public double calcPM(int m, double p) {
    return myPow(p, m);
  }

  public double myPow(double valor, int elevacao) {

    if (elevacao < 0) {
      if (elevacao == Integer.MIN_VALUE) {
        elevacao = (elevacao + 1) * (-1);
        return 1.0 / (myPow(valor * valor, elevacao));
      }
      elevacao = elevacao * (-1);
      return (double) 1.0 / myPow(valor, elevacao);
    }
    double y = 1;
    while (elevacao > 0) {
      if (elevacao % 2 == 0) {
        valor = valor * valor;
      } else {
        y = y * valor;
        valor = valor * valor;
      }
      elevacao = elevacao / 2;
    }
    return y;
  }

  public static void main(String[] args) {
    Solution3 solution3 = new Solution3();
    final double valor1 = solution3.calcPM(1000, 0.999999999999D);
    System.out.println("Teste1:" + valor1);

    final double valor2 = solution3.calcPM(1000000, 0.999999999999D);
    System.out.println("Teste1:" + valor2);

    final double valor3 = solution3.calcPM(1000000000, 0.999999999999D);
    System.out.println("Teste1:" + valor3);
  }
}

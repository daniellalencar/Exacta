package com.exacta.question2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Solution2 {
  public static void main(String[] args) {
    Solution2 solution2 = new Solution2();

    int valoresOrdenados[] = {-2, -1, 0, 2, 4, 7, 8, 9, 9};
    int valorMultiplicacao = 8;

    final Collection<int[]> possibleCombinatios =
        solution2.getPossibleCombinatios(valoresOrdenados, valorMultiplicacao);
    String formatations = "[";
    for (Iterator iterator = possibleCombinatios.iterator(); iterator.hasNext(); ) {
      int[] is = (int[]) iterator.next();
      formatations += "[" + is[0] + ", " + is[1] + "],";
    }
    formatations.substring(formatations.lastIndexOf(","));
    System.out.println(formatations);
  }

  private Collection<int[]> getPossibleCombinatios(int[] valoresOrdenados, int valorSoma) {
    final Map<String, int[]> mapaDeValoresCombinados =
        getMapaDeValoresCombinados(valoresOrdenados, valorSoma);
    return mapaDeValoresCombinados.values();
  }

  protected Map<String, int[]> getMapaDeValoresCombinados(int[] valoresOrdenados, int valorSoma) {
    Map<String, int[]> mapAux = new HashMap<>();
    for (int i = 0; i < valoresOrdenados.length; i++) {
      int posicao = valoresOrdenados[i];
      for (int j = 0; j < valoresOrdenados.length; j++) {
        int valorASerSomado = valoresOrdenados[j];
        int valorParaComparar = valorASerSomado + posicao;
        if (valorParaComparar == valorSoma) {

          int valor[] = new int[2];
          String chaveUnica = "";
          if (posicao < valorASerSomado) {
            chaveUnica = Integer.toString(posicao) + "#" + Integer.toString(valorASerSomado);
            valor[0] = posicao;
            valor[1] = valorASerSomado;
          } else {
            chaveUnica = Integer.toString(valorASerSomado) + "#" + Integer.toString(posicao);
            valor[0] = valorASerSomado;
            valor[1] = posicao;
          }
          mapAux.put(chaveUnica, valor);
        }
      }
    }
    return mapAux;
  }
}

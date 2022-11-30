package br.edu.ifes.si.tpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AlgoritimoTopArtigos {

    private int[] qtdCitacoes; //A quantidade de vezes que o vertice é referenciado
    //Mostra os vértices e a quantidade de vezes que ele f
    public AlgoritimoTopArtigos(Digrafo G) {
        qtdCitacoes = new int[G.V()]; //instancia o vetor com a quantidade de vértice existente no Digrafo
        contarArtigos(G); // chamada da função que contabiliza os vértices
    }

    //função que contabiliza os vertices
    private void contarArtigos(Digrafo G) {
        for (int i = 0; i < G.V(); i++) { //'for' externo,serve para passar como ref o indice do vetor de vertice, lendo 1 a um 1

            for (int j = 0; j < G.V(); j++) {//'for' interno, serve para varrer a lista de adj do vértice selecionado(for externo)
                if (arestasIndtV(G.adj(i)).contains(j)) {//verifica se há incidencia entre vértices, através de função aux.
                    qtdCitacoes[j]++;
                    //Havendo incidencia entre o vértice selecionado e o elemento da lista de adj, increment-sea o elemento testado
                }
            }
        }
        imprimirVetor(qtdCitacoes); //imprimi o vetor de qtdCitacaos

    }

    //função para montar uma lista de vertices incidentes a determinado vertice
    private List<Integer> arestasIndtV(List<Aresta> a) {
        List<Integer> arestas = new ArrayList();
        for (Aresta aresta : a) {
            arestas.add(aresta.getV2());
        }
        return arestas;
    }
    
    //função que imprimi 
    private void imprimirVetor(int[] a) {
        System.out.println("TOP Artigos");
        for (int i = 0; i < a.length; i++) {
            System.out.println(i + ": " + a[i]);
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digrafo G = new Digrafo(in);
        System.out.println(G);
        System.out.println("Quantidade de citações de cada Artigo");
        AlgoritimoTopArtigos algoritimoTopArtigos = new AlgoritimoTopArtigos(G);
    }
}

package br.edu.ifes.si.tpa;

import java.util.ArrayList;
import java.util.List;

public class AlgoritimoMenorQtdArtigosLidos {

    private boolean[] noCaminho;
    private Pilha<Integer> caminho;
    private int numeroDeCaminhos;       // número de caminhos simples
    private List<Pilha> caminhos;
    private Pilha<Integer> rota;

    public AlgoritimoMenorQtdArtigosLidos(Digrafo digrafo, int vo, int vd) {
        noCaminho = new boolean[digrafo.V()];
        caminho = new Pilha<Integer>();
        caminhos = new ArrayList<>();
        dfs(digrafo, vo, vd);
        MenorCaminho();

    }

    private void dfs(Digrafo G, int v, int vd) {

        // adiciona v ao caminho atual
        caminho.empilha(v);
        noCaminho[v] = true;
        // encontrado caminho de v para vd (vértice destino)
        if (v == vd) {
            rota = new Pilha<>();
            for (Integer i : caminho) {
                rota.empilha(i);
            }
            caminhos.add(rota);
            numeroDeCaminhos++;

        } // considerar todos os vizinhos que continuariam o caminho
        else {
            for (Aresta a : G.adj(v)) {
                int x = a.getV2();
                if (!noCaminho[x]) {
                    dfs(G, x, vd);
                }
            }
        }

        // feita a exploração de v, então o remove do caminho
        caminho.desempilha();
        noCaminho[v] = false;
    }

    public void MenorCaminho() {
        int menor = caminhos.get(0).tamanho();
        Pilha<Integer> pilha = caminhos.get(0);
        for (Pilha p : caminhos) {
            if (menor > p.tamanho()) {
                menor = p.tamanho();
                pilha = p;
            }
        }
        imprimeCaminho(pilha);
    }

    private void imprimeCaminho(Pilha<Integer> pilha) {
        if (pilha.tamanho() >= 1) {
            System.out.print(pilha.desempilha());
        }
        while (!pilha.isEmpty()) {
            System.out.print("->" + pilha.desempilha());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digrafo G = new Digrafo(in);
        System.out.println(G);
        AlgoritimoMenorQtdArtigosLidos algoritimoMenorQtdArtigosLidos = new AlgoritimoMenorQtdArtigosLidos(G, 11, 0);

    }
}

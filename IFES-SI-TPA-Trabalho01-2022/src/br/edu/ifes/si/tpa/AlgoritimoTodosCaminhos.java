package br.edu.ifes.si.tpa;

public class AlgoritimoTodosCaminhos {

    private boolean[] noCaminho;
    private Pilha<Integer> caminho;
    private int numeroDeCaminhos;       // número de caminhos simples

    public AlgoritimoTodosCaminhos(Digrafo digrafo, int vo, int vd) {
        noCaminho = new boolean[digrafo.V()];
        caminho = new Pilha<Integer>();
        dfs(digrafo, vo, vd);
    }

    private void dfs(Digrafo G, int v, int vd) {

        // adiciona v ao caminho atual
        caminho.empilha(v);
        noCaminho[v] = true;

        // encontrado caminho de v para vd (vértice destino)
        if (v == vd) {
            imprimeCaminhoAtual();
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

    private void imprimeCaminhoAtual() {
        Pilha<Integer> pilhaInvertida = new Pilha<Integer>();
        for (int v : caminho) {
            pilhaInvertida.empilha(v);
        }
        if (pilhaInvertida.tamanho() >= 1) {
            System.out.print(pilhaInvertida.desempilha());
        }
        while (!pilhaInvertida.isEmpty()) {
            System.out.print("-" + pilhaInvertida.desempilha());
        }
        System.out.println();
    }

    public int numeroDeCaminhos() {
        return numeroDeCaminhos;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digrafo G = new Digrafo(in);
        System.out.println(G);
        System.out.println("todos os caminhos simples entre 1 e 13:");
        AlgoritimoTodosCaminhos todosCaminhos = new AlgoritimoTodosCaminhos(G, 13, 1);
        System.out.println("# caminhos = " + todosCaminhos.numeroDeCaminhos());

    }
}

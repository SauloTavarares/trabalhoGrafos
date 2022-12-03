package br.edu.ifes.si.tpa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Criação do Digrafo
        In in = new In(args[0]);
        Digrafo G = new Digrafo(in);
        System.out.println(G);

        //Funções em cima do Digrefo
        //Função de menor caminho
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o ID do artigo de origem:");
        int vo = scan.nextInt();
        System.out.println("Digite o ID do artigo de destino:");
        int vd = scan.nextInt();
        System.out.println("");
        System.out.println("a) O menor caminho entre " + vo + " e" + vd);
        //Menor caminho de um vértice de origem para um vértice de destino
        AlgoritimoMenorQtdArtigosLidos algoritimoMenorQtdArtigosLidos = new AlgoritimoMenorQtdArtigosLidos(G, vo, vd);
        System.out.println("");
        
         //Função de todos os caminhos
        System.out.println("Digite o ID do artigo de origem:");
        vo = scan.nextInt();
        System.out.println("Digite o ID do artigo de destino:");
        vd = scan.nextInt();
        System.out.println("");
        System.out.println("b) O menor caminho simples entre " + vo + " e" + vd);
        //Todos os caminho de um vértice de origem para um vértice de destinho
        AlgoritimoTodosCaminhos todosCaminhos = new AlgoritimoTodosCaminhos(G, vo, vd);
        System.out.println("# caminhos = " + todosCaminhos.numeroDeCaminhos());
        System.out.println("");
        
        //Função que imprime a quantidade de citações de cada artigo
        System.out.println("c) Top artigos");
        System.out.println("Quantidade de citações de cada Artigo");
        AlgoritimoTopArtigos algoritimoTopArtigos = new AlgoritimoTopArtigos(G);
        System.out.println("");
        
        //Função que imprime a quantidade de vezes que um autor foi citado
        System.out.println("d) Top Autores");
        AlgoritimoTopAutores algoritimoTopAutores = new AlgoritimoTopAutores(G);

    }
}

package br.edu.ifes.si.tpa;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AlgoritimoTopAutores {

    HashMap<Integer, Integer> hashMapArtigoAutor = new HashMap<>(); //HashMap que mapeia o artigo e autor que fez
    int[] autoresArtigo; //Vetor de quantidade de vezes que um autor foi citado 

    public AlgoritimoTopAutores(Digrafo G) {
        mapearAutores(G);
        contarArtigoAutores(G);
        imprimirVetor(autoresArtigo);
    }

    private void mapearAutores(Digrafo G) { //Função que mapeia os autores e os artigos e instancia o vetor de autoresArtigo
        List litaAux = new ArrayList(); //Lista auxiliar para servir como base de definição do tamanho do vetor

        for (Vertice v : G.getAutorsArtigos()) { // 'for' que intera sobre a lista de autores e seus artigos
            hashMapArtigoAutor.put(v.getArtigo(), v.getAutor()); //adicionando no HashMap o arigo como 'key' e autores como 'value'
        }
        
        for (Map.Entry<Integer, Integer> entry : hashMapArtigoAutor.entrySet()) { //interando sobre o HashMap
            Integer value = entry.getValue(); //Pegamos somente o valor
            if (!litaAux.contains(value)) { // verifica se o valor passado do HashMap foi adicionado 
                litaAux.add(value); //Se o valor não foi adiconado então ele adiciona na lista
            }
        }
        autoresArtigo = new int[litaAux.size()]; //Intanciando o vetor a partir do tamanho da lista
    }

    public void contarArtigoAutores(Digrafo G) {
        for (int j = 0; j < G.V(); j++) {//'for' externo,serve para passar como ref o indice do vetor de vertice, lendo 1 a um 1
            for (Aresta a : G.adj(j)) { // 'for' que pega os elementos incidentes ao vértice(incidencia=citação)
                int x = a.getV2(); 
                if (hashMapArtigoAutor.containsKey(x)) {//testa se o vértice incidente encontra-se no HashMap(Somente por garantia)
                    int posicao = hashMapArtigoAutor.get(x);//condição satisfeita, pega-se o valor(id autor)da chave(artigo)passada
                    autoresArtigo[posicao]++;//incrementa ao vetor no indice id autor citado, contabilizando uma citação
                }
            }
        }
    }
    //função que imprimi o vetor
    public static void imprimirVetor(int[] vet) {
        System.out.println("TOP Autores");
        for (int i = 0; i < vet.length; i++) {
            System.out.println(i + ": " + vet[i]);
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digrafo G = new Digrafo(in);
        int[] artigoAutores = new int[4];
        System.out.println(G);
        AlgoritimoTopAutores algoritimoTopAutores = new AlgoritimoTopAutores(G);

    }
}

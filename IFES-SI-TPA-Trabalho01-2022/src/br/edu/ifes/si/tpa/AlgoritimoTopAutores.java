package br.edu.ifes.si.tpa;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AlgoritimoTopAutores {

    HashMap<Integer, Integer> hashMap = new HashMap<>();
    int[] artigoAutores;

    public AlgoritimoTopAutores(Digrafo G) {
        mapearAutores(G);
        contarArtigoAutores(G);
        imprimirVetor(artigoAutores);
    }

    private void mapearAutores(Digrafo G) {
        List list = new ArrayList();

        for (Vertice v : G.getAutorsArtigos()) {
            hashMap.put(v.getArtigo(), v.getAutor());
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer value = entry.getValue();
            if (!list.contains(value)) {
                list.add(value);
            }
        }
        artigoAutores = new int[list.size()];
    }

    public void contarArtigoAutores(Digrafo G) {
        for (int j = 0; j < G.V(); j++) {
            for (Aresta a : G.adj(j)) {
                int x = a.getV2();
                if (hashMap.containsKey(x)) {
                    int posicao = hashMap.get(x);
                    artigoAutores[posicao]++;
                }
            }
        }
    }

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

//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (Vertice v : G.getAutorsArtigos()) {
//            hashMap.put(v.getArtigo(), v.getAutor());
//        }
//
//        System.out.println(hashMap);
//
//        for (int j = 0; j < G.V(); j++) {
//            for (Aresta a : G.adj(j)) {
//                int x = a.getV2();
//                if (hashMap.containsKey(x)) {
//                    int posicao = hashMap.get(x);
//                    System.out.println(posicao);
//                    artigoAutores[posicao]++;
//                }
//            }
//        }
//        for (int j = 0; j < artigoAutores.length; j++) {
//            System.out.println(j + ": " + artigoAutores[j]);
//        }
//    
    }
}

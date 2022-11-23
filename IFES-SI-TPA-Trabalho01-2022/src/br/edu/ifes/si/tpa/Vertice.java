package br.edu.ifes.si.tpa;

public class Vertice {

    private Integer artigo;
    private Integer autor;

    public Integer getAutor() {
        return autor;
    }

    public Integer getArtigo() {
        return artigo;
    }

    public Vertice(Integer artigo, Integer autor) {
        this.artigo = artigo;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "O autor " + this.autor + " escreveu o artigo "+ this.artigo;
    }

}

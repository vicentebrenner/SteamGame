package model;

public class Conquista {
    private String nome;
    private boolean obtido;

    public Conquista(String nome) {
        this.nome = nome;
        this.obtido = false;
    }

    public String getNome() {
        return nome;
    }

    public boolean isObtido() {
        return obtido;
    }

    public void obterConquista() {
        this.obtido = true;
    }
}

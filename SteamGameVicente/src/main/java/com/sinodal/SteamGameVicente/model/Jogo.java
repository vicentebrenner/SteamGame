package model;

import java.util.List;

public class Jogo {
    private String titulo;
    private List<Conquista> conquistas;
    private double tempoDeJogo;
    private double percentualConclusao;

    public Jogo(String titulo, List<Conquista> conquistas, double tempoDeJogo, double percentualConclusao) {
        this.titulo = titulo;
        this.conquistas = conquistas;
        this.tempoDeJogo = tempoDeJogo;
        this.percentualConclusao = percentualConclusao;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Conquista> getConquistas() {
        return conquistas;
    }

    public double getTempoDeJogo() {
        return tempoDeJogo;
    }

    public double getPercentualConclusao() {
        return percentualConclusao;
    }

    public void adicionarConquista(Conquista conquista) {
        this.conquistas.add(conquista);
    }

    public void atualizarTempoDeJogo(double horas) {
        this.tempoDeJogo += horas;
        this.percentualConclusao = calcularPercentualConclusao();
    }

    private double calcularPercentualConclusao() {
        if (conquistas.isEmpty()) return 0;
        long conquistasObtidas = conquistas.stream().filter(Conquista::isObtido).count();
        return (double) conquistasObtidas / conquistas.size() * 100;
    }
}

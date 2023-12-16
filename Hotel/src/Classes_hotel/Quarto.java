package Classes_hotel;

public class Quarto {
    int id_quarto;
    int capacidade_maxima;
    int tamanho_quarto;
    String descricao;

    public int getId_quarto() {
        return id_quarto;
    }

    public void setId_quarto(int id_quarto) {
        this.id_quarto = id_quarto;
    }

    public int getCapacidade_maxima() {
        return capacidade_maxima;
    }

    public void setCapacidade_maxima(int capacidade_maxima) {
        this.capacidade_maxima = capacidade_maxima;
    }

    public Quarto() {
    }

    public int getTamanho_quarto() {
        return tamanho_quarto;
    }

    public void setTamanho_quarto(int tamanho_quarto) {
        this.tamanho_quarto = tamanho_quarto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Quarto(int id_quarto, int capacidade_maxima, int tamanho_quarto, String descricao) {
        this.id_quarto = id_quarto;
        this.capacidade_maxima = capacidade_maxima;
        this.tamanho_quarto = tamanho_quarto;
        this.descricao = descricao;
    }
    
}

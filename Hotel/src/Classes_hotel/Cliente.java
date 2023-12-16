package Classes_hotel;

public class Cliente {
    int id_cliente;
    int cpf;
    String nome;
    int telefone;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public Cliente() {
    }

    public Cliente(int id_cliente, int cpf, String nome, int telefone) {
        this.id_cliente = id_cliente;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
    }
}

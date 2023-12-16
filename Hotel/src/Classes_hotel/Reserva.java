package Classes_hotel;

import java.util.Date;

public class Reserva {
    int id_reserva;
    int id_quarto;
    int id_cliente;
    Date data;
    String nome_cliente;

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getId_quarto() {
        return id_quarto;
    }

    public void setId_quarto(int id_quarto) {
        this.id_quarto = id_quarto;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public Reserva() {
    }

    public Reserva(int id_reserva, int id_quarto, int id_cliente, String nome_cliente, Date data) {
        this.id_reserva = id_reserva;
        this.id_quarto = id_quarto;
        this.id_cliente = id_cliente;
        this.data = data;
        this.nome_cliente = nome_cliente;
    }
    
}
